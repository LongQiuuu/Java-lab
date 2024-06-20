package tw.brad.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
//資料庫連結寫入行為  配合 Register Brad23 搭配使用 前後端分離
public class MemberDB {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER ="root";
	private static final String PASSWD ="root";
	private static final String URL ="jdbc:mysql://localhost:3306/iii";
	private static final String CHECK_SQL = "SELECT count(*) count FROM member WHERE account=?";
	private static final String INSERT_SQL = "INSERT INTO member (account,passwd,realname) VALUES (?,?,?)";
	
	//連結資料庫
	private Connection conn;

	//查詢資料
	private ResultSet rs;
	
	
	//連接資料庫方法
	public MemberDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, prop);
	}
	
	
	//提供對外營業方法
	public int addNew(String account, String passwd, String realname) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, realname);
		//傳回整數
		return pstmt.executeUpdate();
	}
	
	//確認帳號是不是有重複存在
	public boolean isAccountExist(String account) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(CHECK_SQL);
		pstmt.setString(1, account);
		rs = pstmt.executeQuery();
		rs.next();
		return rs.getInt("count") > 0; 
	}
	
	
		
}
