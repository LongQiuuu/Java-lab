package tw.brad.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

import tw.brad.apis.WSClient;

//這隻可以寫 還可以讓另外一隻接收
//聊天室的後端寫法
//一定要加上 資源要帶到
@ServerEndpoint("/mycenter")
public class MyCenter {
	//宣告擁有Session 類別
	//因為有可能會重複資料且無順序性 所以使用HashSet<E>
	//此段功能是要確定不重複
	private static HashSet<Session> sessions = null;
	//宣告擁有 我有一個key可以調用他  為啥這邊會用String 因為連線方法是回傳字串
	//此段功能是來調用值
	private static LinkedList<WSClient> users;
	
	//建構式
	public  MyCenter() {
		//因為我上面是使用static 方法 所以建構式會一直刷新觸發 
		//為了不要讓他一直重複觸發 所以再加一個判斷式
		//初始化上方宣告擁有的內容
		if (sessions == null) {
				sessions = new HashSet<>();
				users = new LinkedList<WSClient>();
		}	
	}
	
	//有人要跟我連線方法被觸發  @OnOpen一定要加工法在這
	@OnOpen
	public void onOpen(Session session ) {
		//將網頁待網時間拉長一些		
		session.setMaxIdleTimeout(60*60*1000);	
		//資料結構的add方法會回傳布林值
		if (sessions.add(session)) {
			//當他這個值沒有重複的, 我就呼叫並建立WSClient方法
			WSClient wsClient = new WSClient();
			wsClient.setSession(session);
			//將這個方法加入users
			users.add(wsClient);
		}
	}
	
	//發生傳送訊息觸發方法 （ 傳送訊息 ,是哪個連線發生問題）
	@OnMessage
	public void onMessage(String mesg, Session fromSession) {
		System.out.println(mesg);
		//建立一個新的JSON物件實體
		JSONObject root = new JSONObject(mesg);		//
		//如果是第一個進來連線的 你就可以在紙上作畫
		if (root.getBoolean("init")) {
			//如果是 我就將clent1 內容放上去 並把開關改成true
			for (WSClient wsClient : users) {
				if (wsClient.getSession().equals(fromSession)) {
					wsClient.setClient1(true);
					break;
				}
			}	
		
		//如果不是第一個進來的 你就只能看第一個進來畫的圖
		}else {
			// 製作 JSONObject, 發送給 client2
			JSONObject sendObj = new JSONObject();
			sendObj.put("isNewLine", root.getBoolean("isNewLine"));
			sendObj.put("isClear", root.getBoolean("isClear"));
			sendObj.put("x", root.getInt("x"));
			sendObj.put("y", root.getInt("y"));
			
			for (WSClient user : users) {
				if (!user.isClient1()) {
					try {
						user.getSession().getBasicRemote().sendText(sendObj.toString());
					} catch (IOException e) {
						System.out.println(e);
					}
				}
			}
			
			
		}
		
	}
	
	//發生關閉觸發方法（是哪個連線發生問題）
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose");
		//先尋訪所有的值
		for (WSClient wsClient : users) {
			//再來判斷裡面有沒有相同
			if (wsClient.getSession().equals(session)) {
				//有相同移除連線
				sessions.remove(session);
				//移除用戶
				users.remove(wsClient);
				//跳出迴圈
				break;
			}
		}
	
	}
	
	//發生錯誤觸發方法 （是哪個連線發生問題 ,拋出錯誤以t去接）
	@OnError
	public void onError(Session session ,Throwable t ) {
		System.out.println("onError");
	}
	
}
