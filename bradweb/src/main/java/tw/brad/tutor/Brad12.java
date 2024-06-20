package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//將Brad13的資料加入此筆檔案裡 
//且只剩下brad13的資料
@WebServlet("/Brad12")
public class Brad12 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//getRequestDispatcher("分支出去的地點");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad13");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>Brad Big Company</h1>");
		out.print("<hr />");
		out.print("<div>Hello, World</div>");
		
		//將Brad13的資料加入此筆檔案裡 
		//forward且只剩下brad13的資料
		
		dispatcher.forward(request, response);
		out.print("<hr />");

		response.flushBuffer();
	}

}