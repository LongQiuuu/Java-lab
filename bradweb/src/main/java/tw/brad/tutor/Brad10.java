package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//此檔前後端不分離

//將別的檔案的資料內容加入到自己的資料裡
@WebServlet("/Brad10")
public class Brad10 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//getRequestDispatcher("分支出去的地點");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad11");
		
		//若有多個參數要回傳 可以使用
		request.setAttribute("range", 100);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>Brad Big Company</h1>");
		out.print("<hr />");
		out.print("<div>Hello, World</div>");
		
		//將Brad10.html的資料加入此筆檔案裡 
		//也可以說是我把11的結果放到10號這個版面
		//在測試網頁時記得在後面加？參數Brad10?min=100 才可以正常測試
		dispatcher.include(request, response);
		out.print("<hr />");
		
		response.flushBuffer();
	}

	

}
