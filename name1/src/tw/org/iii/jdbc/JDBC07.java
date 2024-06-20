package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

//資料庫查找資料 並讓使用者輸入來做模糊比對
public class JDBC07 {

	public static void main(String[] args) {
		//因為要讓使用者輸入 使用Scanner語法
		System.out.print("關鍵字: ");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		String kw = "%" +key + "%";
			
		
		//資料庫連接
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		//最簡單的查詢語法
		//也可以寫成別名
		//因為怕被別人用隱碼攻擊所以這邊選擇使用PreparedStatement  這邊才會有？產生
		String sql ="SELECT * FROM food where name LIKE ? OR addr LIke ?  OR city LIKE ? OR town LIKE ?";
		
		//寫在try()裡就可以 自動關閉此次包三道道敘述句 只要可自動關閉的api 都可以放進去
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii", prop);
				//因為怕被別人用隱碼攻擊所以這邊選擇使用PreparedStatement
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			//設定我上方？要填入的值
			pstmt.setString(1,kw);	
			pstmt.setString(2,kw);	
			pstmt.setString(3,kw);	
			pstmt.setString(4,kw);	
			
			//將SQL放進去並回傳 ResultSet ＝指向查詢表單  預設只能往前 不能往後 所以我從五開始 不能再叫四
			ResultSet rs = pstmt.executeQuery();
			//讀出所有的值
			while (rs.next()) {
				String id = rs.getString("id");
				String addr = rs.getString("addr");
				String city = rs.getString("city");
				String town = rs.getString("town");
				System.out.printf("%s : %s : %s : %s\n", id, addr, city, town);
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
