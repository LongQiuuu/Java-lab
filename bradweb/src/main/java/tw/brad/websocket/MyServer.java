package tw.brad.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

//這隻只能單純寫
//聊天室的後端寫法
//一定要加上 資源要帶到
@ServerEndpoint("/myserver")
public class MyServer {
	//宣告擁有Session 類別
	//因為有可能會重複資料且無順序性 所以使用HashSet<E>
	//此段功能是要確定不重複
	private static HashSet<Session> sessions = null;
	//宣告擁有 我有一個key可以調用他  為啥這邊會用String 因為連線方法是回傳字串
	//此段功能是來調用值
	private static HashMap<String, Session> users = null;
	
	//建構式
	public  MyServer() {
		//因為我上面是使用static 方法 所以建構式會一直刷新觸發 
		//為了不要讓他一直重複觸發 所以再加一個判斷式
		//初始化上方宣告擁有的內容
		if (sessions == null) {
			sessions = new HashSet<>();
			users = new HashMap<String, Session>();
		}
		
		
	}
	
	//有人要跟我連線方法被觸發  @OnOpen一定要加工法在這
	@OnOpen
	public void onOpen(Session session ) {
		
		
		//資料結構的add方法會回傳布林值
		if (sessions.add(session)) {
			//當他這個值沒有重複的, 我就將users加入進來
			users.put(session.getId(), session);
		}
		//看看我們現在有幾個連線
		System.out.println("Count:" + sessions.size());
	}
	
	//發生傳送訊息觸發方法 （ 傳送訊息 ,是哪個連線發生問題）
	@OnMessage
	public void onMessage(String mesg, Session fromSession) {
		System.out.println(mesg);
		//將收到的訊息傳送給所有人 
		for (Session session : sessions) {
			try {
				//每個人取的遠端的誰（） .對他發送文字資料  
				session.getBasicRemote().sendText(mesg);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
				
	}
	
	//發生關閉觸發方法（是哪個連線發生問題）
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose");
		//將user 移除   webSocket會自動給id 且唯一
		users.remove(session.getId());
		//將Session移除
		sessions.remove(session);
	}
	
	//發生錯誤觸發方法 （是哪個連線發生問題 ,拋出錯誤以t去接）
	@OnError
	public void onError(Session session ,Throwable t ) {
		System.out.println("onError");
	}
	
}
