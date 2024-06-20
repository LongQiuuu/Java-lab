package tw.org.iii.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.org.iii.apis.BCrypt;
import tw.org.iii.apis.Bike;
//將腳踏車物件傳入資料庫
public class JDBC14 {
	private static final String USER ="root";
	private static final String PASSWD ="root";
	private static final String URL ="jdbc:mysql://localhost:3306/iii";
	private static final String UPDATE_SQL ="UPDATE member SET bike =? WHERE id =?";
	
	
	
	
	
	public static void main(String[] args) {
		//創造腳踏車物件實體
		Bike b1 =new Bike ();
		b1.upSpeed();
		
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);	
		
		

		try {
			//連線資料庫
			Connection conn = DriverManager.getConnection(URL, prop);
			
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);
			
		
			//？值設帶入 放入物件
			pstmt.setObject(1, b1);
			pstmt.setInt(2, 1);
			//資料上傳至資料庫
			if (pstmt.executeUpdate()>0) {
				System.out.println("成功上傳");
			}
			
						
				
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}
}


