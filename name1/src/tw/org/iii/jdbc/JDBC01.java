package tw.org.iii.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//用戶端資料庫連接第一個程式
public class JDBC01 {
	public static void main(String[] args) {
		
		try {
			//載入ＪＤＢＣ驅動程式
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			//產生連線使用官方的API  JAVA .SQL
			
			//跟資料庫產生連線
			//	Connection conn = DriverManager.getConnection(主機名稱 port號 / ？ 連接資料名稱 帳號密碼）
			//getConnection("jdbc:mysql://localhost連接port號/表單名稱?user=root&password=root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii?user=root&password=root");
			System.out.println("OK");
			//產生敘述句的物件並且執行敘述句
			Statement stmt =conn.createStatement();
			//新增 刪除 修改
			//新增表單上去
			int n = stmt.executeUpdate("INSERT INTO cust (cname, tel, birthday) VALUES" + 
					" ('brad1','123','1999-01-02')," +
					" ('brad2','123','1999-01-02')," +
					" ('brad3','123','1999-01-02')");
				
				
				//此時檢查有幾筆筆資料上傳
				System.out.println(n);
			
			
		} catch (Exception e) {
		
		
		}
		
	}
	
	
}
