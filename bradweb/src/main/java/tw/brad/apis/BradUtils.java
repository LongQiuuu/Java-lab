package tw.brad.apis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedMap;

import org.json.JSONArray;
import org.json.JSONObject;

//將html 資料全部讀進來的api
public class BradUtils {
	//讀檔案
	public static String loadView(String view) throws Exception {
		
		//讀哪個檔案的路徑 //為了可以隨時更換版本 .format  %s處理
		String source = String.format("/Users/long/eclipse-workspace/bradweb/src/main/webapp/views/%s.html",view);
		
		File viewFile = new File(source);
		int len = (int)viewFile.length();
		byte[] buf = new byte[len];
		FileInputStream fin = new FileInputStream(viewFile);
		fin.read(buf);
		fin.close();
		
		return new String(buf);
	}
	
	//加法運算配合brad32.jsp
	public static String calc(String x, String y, String op) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			StringBuffer sb = new StringBuffer();
			switch (op) {
				case "1": sb.append(intX + intY); break;
				case "2": sb.append(intX - intY); break;
				case "3": sb.append(intX * intY); break;
				case "4": 
					sb.append(intX / intY).append(" ...... ").append(intX % intY); 
					break;
			}
			return sb.toString();
			
		}catch(Exception e) {
			return "";
		}
	}
	
	//產生成績配合brad41.jsp
	public static int createScore() {
		return (int)(Math.random()*101);
	}
	
	//解ＪＳＯＮ配合brad49.jsp
	public static LinkedList<HashMap<String, String>> parseTravel(String data){
		LinkedList<HashMap<String, String>> items = new LinkedList<HashMap<String,String>>();
		JSONArray root = new JSONArray(data);
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			HashMap<String, String> item = new HashMap<String, String>();
			//item.put("資料庫欄位名稱", row.getString("抓取開放資料的欄位名稱"));
			item.put("name", row.getString("Name"));
			item.put("city", row.getString("City"));
			item.put("town", row.getString("Town"));
			items.add(item);
		}
		
		return items;
	}

	
		
	
	//JSON 字串格式 { [ { } ] }
	//將撈取的資料 轉成 json字串  配合brad58
	public static String Order2JSON(SortedMap[] rows) {
		//製作JSON 字串最外層的{}
		JSONObject root = new JSONObject();
		//製作{}裡面的內容
		//判斷有沒有資料
		if (rows.length >0) {
			//  "自訂義變數" , 抓第一筆資料 ,row.getOrDefault("要抓取資料庫欄位名稱", "抓不到資料顯示什麼")
			root.put("orderId", rows[0].getOrDefault("OrderID", ""));
			root.put("customerId", rows[0].getOrDefault("CustomerID", ""));
			root.put("date", rows[0].getOrDefault("OrderDate", ""));
			//製作{}裡面的字串[]
			JSONArray details = new JSONArray();
			//製作[]裡面的資料
			for (int i=0; i<rows.length; i++) {
				SortedMap<String, String> row = rows[i];
				//製作[]裡面的{}
				JSONObject detail = new JSONObject();
				//製作{}裡面的資料
				//detail.put("自訂義欄位", row.getOrDefault("要抓取資料庫欄位名稱", "抓不到資料顯示什麼"));
				detail.put("productId", row.getOrDefault("ProductID", ""));
				detail.put("productName", row.getOrDefault("ProductName", ""));
				detail.put("unitPrice", row.getOrDefault("UnitPrice", ""));
				detail.put("quantity", row.getOrDefault("Quantity", ""));
				details.put(detail);
			}
			//將上面做完的陣列放到root裡面
			root.put("details", details);
		}
		System.out.println(root.toString());
		return root.toString();
	}
	
}
