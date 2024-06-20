package tw.org.iii.jdbc;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

//將農委會的ＪＳＯＮ資料傳到資料庫 老師寫法
public class JDBC05 {

	public static void main(String[] args) {
		try {
			
			//抓資料
			URL url =new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx?&UnitId=193");
			URLConnection conn =url.openConnection();
			
			//文字資料使用BufferedReader 用三根管子連接
			BufferedReader reader =new BufferedReader (new InputStreamReader(conn.getInputStream()));
			//一次讀一列
			String line ;
			StringBuffer sb =new StringBuffer();
			
			while ((line=reader.readLine())!=null) {
				//System.out.println(line);
				//將line的字串與sb字串相加
				sb.append(line);
			}
			
			reader.close();
			parseJSON(sb.toString());
			
		} catch (Exception e) {
			
			System.out.println(e);
		}

	}
	//解資料方法
	static void parseJSON(String json) {
		//驗算看看有沒有抓到資料
		System.out.println(json);
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii", prop)){
			
			//可以讓他重複執行 不會讓他按很多次就會重複一直建立資料表
			Statement stmt = conn.createStatement();
			//刪除food表單裡面所有資料
			stmt.executeUpdate("DELETE FROM food");
			//因為前面ID 會自動遞增 所以這邊要將ＩＤ歸零
			stmt.executeUpdate("ALTER TABLE food AUTO_INCREMENT = 1");
			
			String sql = "INSERT INTO food (name,addr,tel,city,town,picurl,lat,lng)" + 
			" VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//再來將元素一個一個取出來
			JSONArray root =new JSONArray(json);
			for(int i =0; i<root.length();i++) {
			
			//撈json資料因為資料來源是字串 先用字串撈
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String addr = row.getString("Address");
				String tel = row.getString("Tel");
				String city = row.getString("City");
				String town = row.getString("Town");
				String picurl = row.getString("PicURL");
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
			
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setString(3, tel);
				pstmt.setString(4, city);
				pstmt.setString(5, town);
				pstmt.setString(6, picurl);
			
			//但因為有浮點數 轉成 上傳
			//但因為解析過程可能產生意外所以要使用try catch 
				try {
					pstmt.setDouble(7, Double.parseDouble(lat));
					pstmt.setDouble(8, Double.parseDouble(lng));
				//如果發生解失敗 將預設值改為0.0
				}catch(Exception e) {
					pstmt.setDouble(7, 0.0);
					pstmt.setDouble(8, 0.0);
				}
				//資料上傳
				pstmt.executeUpdate();
				
			}
			//程式碼如果跑到這段 就代表有上傳成功了
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e);
		}
				
			
	}
		
		
	
}
