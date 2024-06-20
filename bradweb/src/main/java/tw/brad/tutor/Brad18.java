package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//從資料庫裡面撈資料  並顯示在網頁上
//再開始做之前 先把mySql得驅動程式放到 WEB-iNF 資料夾裡面的lib資料夾裡
@WebServlet("/Brad18")
public class Brad18 extends HttpServlet {
	private Connection conn;
	
	//一次性的動作 寫在建構式  例如連線跟載入驅動程式
	public Brad18() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/iii?user=root&password=root");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//輸出
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<table border='1'>");
		out.print("<tr><th>Name</th><th>Tel</th></tr>");
		
		String key = request.getParameter("key");
		String sql = "SELECT * FROM food WHERE name LIKE ?";
		//若我key得值沒帶就自動搜尋全部表單
		if (key==null) {
			sql = "SELECT * FROM food ";
		}
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//模糊搜尋所以在網頁驗證的時候要在後面 Brad18 ?key=
			pstmt.setString(1, "%" + key + "%");
			ResultSet rs = pstmt.executeQuery();
			//將查詢結果放入
			while (rs.next()) {
				out.print("<tr>");
				out.print(String.format("<td>%s</td>",rs.getString("name")));
				out.print(String.format("<td>%s</td>",rs.getString("tel")));
				out.print("</tr>");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		out.print("</table>");
		

		response.flushBuffer();
	}

}