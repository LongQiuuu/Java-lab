package tw.org.iii.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

//用戶端資料庫連接第三種種寫法
public class JDBC03 {
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
			//產生敘述句的物件並且執行敘述句
			Statement stmt =conn.createStatement();
			//新增 刪除 修改
			//新增表單上去
			int n = stmt.executeUpdate("INSERT INTO cust (cname, tel, birthday) VALUES" + 
					" ('brada','123','1999-01-02')," +
					" ('bradb','123','1999-01-02')," +
					" ('bradc','123','1999-01-02')");
				
				
				//此時檢查有幾筆筆資料上傳
				System.out.println(n);
			
			
		} catch (Exception e) {
		
		
		}
		
	}
	
	
}
