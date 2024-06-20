package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//資料庫查找資料
public class JDBC06 {

	public static void main(String[] args) {
		//資料庫連接
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		//最簡單的查詢語法
		//也可以寫成別名
		//
		String sql ="SELECT * FROM food";
		
		//寫在try()裡就可以 自動關閉此次包三道道敘述句 只要可自動關閉的api 都可以放進去
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii", prop);
				//以 Statement 物件執行 SQL 陳述式
				Statement stmt = conn.createStatement();
				//將SQL放進去並回傳 ResultSet ＝指向查詢表單  預設只能往前 不能往後 所以我從五開始 不能再叫四
				ResultSet rs = stmt.executeQuery(sql)){
			
				//拿到rs 這個物件 next 移到第一筆
				//rs.next();
				//讀取第一筆資料
				//如果上方搜尋語法有用別名String id =rs.getString("更改的別名欄位");
				//String id =rs.getString("id");
				//讀取第一筆資料的第二個欄位
				//String name =rs.getString("name");
				//System.out.println(name);
				//拿到rs 這個物件 next 移到第二筆
				//rs.next();
				//讀取第二筆資料第一格欄位
				//id =rs.getString("id");
				//讀取第二筆資料的第二個欄位
				//name =rs.getString("name");
				//System.out.println(name);
				
				//用迴圈讀取全部資料
				while (rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					Double lat = rs.getDouble("lat");
					Double lng = rs.getDouble("lng");
					System.out.printf("%s : %s : %f : %f\n", id, name, lat, lng);
				}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
