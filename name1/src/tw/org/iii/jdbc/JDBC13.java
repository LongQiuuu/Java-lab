package tw.org.iii.jdbc;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.imageio.ImageIO;
//取得資料庫照片並另存新檔
public class JDBC13 {
	
	private static final String USER ="root";
	private static final String PASSWD ="root";
	private static final String URL ="jdbc:mysql://localhost:3306/iii";
	private static final String QUERY_SQL = "SELECT * FROM member WHERE id = ?";
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);	
		
		
		
		try {
			//連線資料庫
			Connection conn = DriverManager.getConnection(URL, prop);
			
			PreparedStatement pstmt = conn.prepareStatement(QUERY_SQL);
			pstmt.setInt(1, 1);
			
			//拿到結果
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next ()) {
				//取得資料庫icon 欄位的照片
				InputStream is = rs.getBinaryStream("icon");
				//-------------
				//將資料庫取的照片另存新檔到dir4 資料夾
				FileOutputStream fout = new FileOutputStream("dir4/brad.jpg");
				byte[] buf = new byte[128*1024];
				int len = is.read(buf);
				fout.write(buf, 0, len);
				fout.flush();
				fout.close();
				
				is.close();
				System.out.println("OK");
				
			}
			
						
				
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
