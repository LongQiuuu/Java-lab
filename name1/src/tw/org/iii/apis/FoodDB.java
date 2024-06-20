package tw.org.iii.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//去連接美食小吃資料庫資料 （資料庫）
public class FoodDB {
	private static final String USER ="root";
	private static final String PASSWD ="root";
	private static final String URL ="jdbc:mysql://localhost:3306/iii";
	private static final String QUERY_SQL = "SELECT * FROM food";
	
	
	//資料庫連線物件
	private Connection conn;
	//資料庫指標物件 ResultSet沒有null 為了讓下面方便判斷 先將他預設成null
	private ResultSet rs =null;
	//定義欄位名稱陣列
	private String[] fieldNames;
	
	//throws Exception拋出例外
	public FoodDB() throws Exception{
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		//資料庫連線
		conn = DriverManager.getConnection(URL, prop);
		
		
	}
	
	//查全部
	public void query()  throws SQLException {
		query( QUERY_SQL);
	}
	//我指定的資料庫
	public void query(String sql) throws SQLException {
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		
		//取的直得欄位有幾條
		ResultSetMetaData rsmd = rs.getMetaData();
		//才可以知道橫的陣列長度 並初始化陣列長度
		fieldNames = new String[rsmd.getColumnCount()];
		
		//將欄位名稱  放到陣列裡面
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnName(i+1);
		}
		
		
	}
	
	//取得有幾筆row資料
	public int getRows() {
		try {
			//先將指標移動到最後
			rs.last();
			//再傳回有幾筆
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	//移動到第幾個 row
	// 1-base
		public void move(int row) throws Exception{
			//絕對定位
			rs.absolute(row);
		}
		
		
	
	
	
	
	//取得有幾個欄位
	public int getCols() {
		return fieldNames.length;
	}
	
	
	//取得資料 // row, col => 1-base 先定義從一開始
	public String getData(int row, int col) {
		try {
			//跳到絕對位置
			rs.absolute(row);
			//陣列從零開始所以這邊要-1
			return rs.getString(fieldNames[col-1]);
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	//取得標題列
	public String[] getHeader() {
		return fieldNames;
	}
	
	
	//砍資料功能
	public void delData(int row) throws Exception {
		//絕對定位
		rs.absolute(row);
		//刪除功能
		rs.deleteRow();
	}
	
	//修改資料
	// row, col => 1-base
	public void updateData(int row, int col, String value) {
		try {
			rs.absolute(row);
			rs.updateString(col, value);
			rs.updateRow();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
