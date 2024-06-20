package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.org.iii.apis.BCrypt;

//將帳號密碼 加鹽並上傳至資料庫
public class JDBC10 {

	public static void main(String[] args) {
		String account="dog";
		String passwd="123456";
		String realname="狗";
		
		//加鹽動作
		String hwpasswd= BCrypt.hashpw(passwd, BCrypt.gensalt());
		
		String sql ="INSERT INTO member (account ,passwd ,realname) VALUES (?,?,?)";
		
		//資料庫連接
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii", prop);
				//因為怕被別人用隱碼攻擊所以這邊選擇使用PreparedStatement
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			//設定我上方？要填入的值
			pstmt.setString(1,account);	
			pstmt.setString(2,hwpasswd);	//將加鹽的密碼放進去
			pstmt.setString(3,realname);	
			//資料上傳
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("OK");
			}else {
				System.out.println(sql);
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
