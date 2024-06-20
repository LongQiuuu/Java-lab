package tw.org.iii.jdbc;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

//用戶端資料庫連接第三種種寫法
public class JDBCJSON {
	public static void main(String[] args) {
		//讀取ＪＳＯＮ字串
		try {
			URL url =new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx?&UnitId=197");
			URLConnection urlConnection =url.openConnection();
			
			//為了使用它的功能 強制轉型
			HttpsURLConnection conn =(HttpsURLConnection)urlConnection;
			
			//取得頁面原始碼
			BufferedReader br =new BufferedReader (new InputStreamReader(conn.getInputStream()));
			
			String line ;
			//農委會
			StringBuffer sb =new StringBuffer();
			
			while ((line=br.readLine())!=null) {
				//System.out.println(line);
				//將line的字串與sb字串相加
				sb.append(line);
			}
			
			br.close();
			//呼叫解JSON方法
			parseJson(sb.toString());
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	


//解json字串方法 我的寫法
	private static void parseJson(String json){
		//這邊使用外接API 因為原廠沒有這個AIP  上網去抓別人的Jar
		//https://github.com/stleary/JSON-java/tree/master?tab=readme-ov-file
		JSONArray root =new JSONArray(json);
		
		try {
			
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/JJJS", prop);
			
		for(int i=0; i<root.length();i++) {
			JSONObject row =root.getJSONObject(i);
			String sql = "INSERT INTO JSONN (Name,Latitude) VALUES (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, row.getString("Name"));
			pstmt.setDouble(2, row.getDouble("Latitude"));
		
			//資料上傳
			pstmt.executeUpdate();
			
			}
			} catch (Exception e) {
			System.out.println(e);
			
			}
	}
}

