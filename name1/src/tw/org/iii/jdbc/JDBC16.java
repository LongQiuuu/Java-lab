package tw.org.iii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

//資料庫指向座標 加上資料庫資料修改
public class JDBC16 {
	
	private static final String USER ="root";
	private static final String PASSWD ="root";
	private static final String URL ="jdbc:mysql://localhost:3306/iii";
	private static final String QUERY_SQL = "SELECT * FROM food";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);	
		
		
		
		try {
			//連線資料庫
			Connection conn = DriverManager.getConnection(URL, prop);
			//為了讓指向可以來回移動 須在後方多加參數  原本預設只能前進不能回頭
			//ResultSet.TYPE_SCROLL_INSENSITIVE = 滾動 不敏感
			//ResultSet.CONCUR_UPDATABLE ＝可以移動
			PreparedStatement pstmt = conn.prepareStatement(QUERY_SQL,ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			//尋訪所有資料並印出
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s \n",id,name);
			}
			//rs.first移到第一筆 再印出看看
			if (rs.first()) {
				System.out.println("OK");
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s \n",id,name);
				
				//絕對位置移動到第五筆
				rs.absolute(5);  //這便可以看出資料庫是從一開始
				id = rs.getString("id");
				name = rs.getString("name");
				System.out.printf("%s:%s \n",id,name);
				
				//第五筆資料來修改
				rs.updateString("tel","04-12345678");
				rs.updateString("city","台中市");
				//將修改資料上傳
				rs.updateRow();
				
				//刪除資料 (會刪除整筆）
				//rs.deleteRow();
				
				//把指標移到最後一筆新增資料
				rs.moveToInsertRow();
				rs.updateString("tel","04-12345678");
				rs.updateString("name","大飯店");
				
				//將新增的Row 上傳到資料庫
				rs.insertRow();
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
			}
	}

}
