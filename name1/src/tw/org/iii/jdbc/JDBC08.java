package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//資料庫查找資料 並讓使用者輸入來做資料產出分頁
public class JDBC08 {

	public static void main(String[] args) {
		//一頁固定
		final int  rpp =10;
		//因為要讓使用者輸入 使用Scanner語法
		System.out.print("你想看第幾頁: ");
		Scanner scanner = new Scanner(System.in);
		int page = scanner.nextInt()-1;
		int start =(page-1)*rpp;
			
		
		//資料庫連接
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		//最簡單的查詢語法
		//也可以寫成別名
		//因為怕被別人用隱碼攻擊所以這邊選擇使用PreparedStatement  這邊才會有？產生
		String sql ="SELECT * FROM food LIMIT ? ,?";
		
		//寫在try()裡就可以 自動關閉此次包三道道敘述句 只要可自動關閉的api 都可以放進去
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii", prop);
				//因為怕被別人用隱碼攻擊所以這邊選擇使用PreparedStatement
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			//設定我上方？要填入的值
			pstmt.setInt(1,start);	
			pstmt.setInt(2,rpp);	
				
			
			//將SQL放進去並回傳 ResultSet ＝指向查詢表單  預設只能往前 不能往後 所以我從五開始 不能再叫四
			ResultSet rs = pstmt.executeQuery();
			//讀出所有的值
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s : %s \n", id, name);
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
