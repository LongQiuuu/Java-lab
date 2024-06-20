package tw.org.iii.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//用戶端資料庫連接第二種寫法
public class JDBC02 {
	public static void main(String[] args) {
		
		try {
			//載入ＪＤＢＣ驅動程式
			//新版的JAVA 可以不用特別寫這段 可以簡略
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//產生連線使用官方的API  JAVA .SQL
			
			//跟資料庫產生連線
			//第二種寫法連接
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii","帳號","密碼");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii","root","root");
			
			
			System.out.println("OK");
			//產生敘述句的物件並且執行敘述句
			Statement stmt =conn.createStatement();
			//新增 刪除 修改
			//新增表單上去
			int n = stmt.executeUpdate("INSERT INTO cust (cname, tel, birthday) VALUES" + 
					" ('brad7','123','1999-01-02')," +
					" ('brad8','123','1999-01-02')," +
					" ('brad9','123','1999-01-02')");
				
				
				//此時檢查有幾筆筆資料上傳
				System.out.println(n);
			
			
		} catch (Exception e) {
		
		
		}
		
	}
	
	
}
