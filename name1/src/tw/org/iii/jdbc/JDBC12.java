package tw.org.iii.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.org.iii.apis.BCrypt;
//將照片傳入資料庫
public class JDBC12 {
	private static final String USER ="root";
	private static final String PASSWD ="root";
	private static final String URL ="jdbc:mysql://localhost:3306/iii";
	private static final String UPDATE_SQL ="UPDATE member SET icon =? WHERE id =?";
	
	
	
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);	
		
		

		try {
			//連線資料庫
			Connection conn = DriverManager.getConnection(URL, prop);
			
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);
			
			//串流
			FileInputStream fin =new FileInputStream("dir1/test2.jpg");
			//？值設帶入 串流值放入
			pstmt.setBinaryStream(1, fin);
			pstmt.setInt(2, 1);
			//資料上傳至資料庫
			if (pstmt.executeUpdate()>0) {
				System.out.println("OK");
			}
			
						
				
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}
}


