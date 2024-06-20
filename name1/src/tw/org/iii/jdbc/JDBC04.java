package tw.org.iii.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

//用戶端資料庫連接第三種種寫法
public class JDBC04 {
	public static void main(String[] args) {
		
		try {
			//載入ＪＤＢＣ驅動程式
			//新版的JAVA 可以不用特別寫這段 可以簡略
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//產生連線使用官方的API  JAVA .SQL
			
			//跟資料庫產生連線
			//第三種種寫法連接 
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii", prop);
			
			
			System.out.println("OK");
			
			//將要填上去的資料庫庫內容格式
			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)";
			
			//預先準備好的敘述句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//將資料庫內容格式的問號來做設定  
			//java 資料庫從一開始 跟以往從零開始很不一樣
			//這種寫法可以避免隱碼攻擊 因為我已經把格式都設定好了 且都設成字串 不讓他成為變數
			pstmt.setString(1, "tony");
			pstmt.setString(2, "456");
			pstmt.setString(3, "1997-02-03");
			//資料上傳
			int n= pstmt.executeUpdate();
			
				
				
				//此時檢查有幾筆筆資料上傳
				System.out.println(n);
			
			
		} catch (Exception e) {
		
		
		}
		
	}
	
	
}
