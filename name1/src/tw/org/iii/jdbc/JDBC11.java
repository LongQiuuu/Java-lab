package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.org.iii.apis.BCrypt;

//連線資料庫 來看帳號密碼正不正確 如果正確還可以同時更改密碼
public class JDBC11 {

	public static void main(String[] args) {
		//資料庫連接
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");	
		
		//讓使用者輸入	
		System.out.print("Account: ");
		Scanner scanner = new Scanner(System.in);
		String inputAccount = scanner.next();
		System.out.print("Password: ");
		String inputPasswd = scanner.next();
		
		//預存輸入
		String sql = "SELECT * FROM member WHERE account = ?";
		try {
			//連線資料庫
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/iii", prop);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//？值設帶入
			pstmt.setString(1, inputAccount);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String hwPasswd = rs.getString("passwd");
				//檢查加鹽的密碼有沒有錯誤
				if (BCrypt.checkpw(inputPasswd, hwPasswd)) {
					//登入成功重新設定會員密碼的ID
					int id = rs.getInt("id");
					String realname = rs.getString("realname");
					System.out.printf("Welcome, %s\n", realname);
					
					//登入成功可以選擇要不要更換密碼 
					System.out.print("New Password: ");
					String newPasswd = scanner.next();
					//如果選擇不更換打exit就可跳出
					if (!newPasswd.equals("exit")) {
						String hwNewPasswd = BCrypt.hashpw(newPasswd, BCrypt.gensalt());
						String chpasswdSQL = "UPDATE member SET passwd = ? WHERE id = ?";
						PreparedStatement pstmtCh = conn.prepareStatement(chpasswdSQL);
						pstmtCh.setString(1, hwNewPasswd);
						pstmtCh.setInt(2, id);
						if (pstmtCh.executeUpdate() > 0) {
							System.out.println("Change Password Success.");
						}else {
							// update passwd failure
							System.out.println(chpasswdSQL);
						}
						
					}	
					
				}else {
					// Passwd ERROR
					System.out.println("Passwd ERROR");
				}
			}else {
				// Account ERROR
				System.out.println("Account ERROR");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
