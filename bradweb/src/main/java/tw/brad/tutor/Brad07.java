package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad07")
public class Brad07 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//取得參數
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		//男生女生
		boolean isMale = request.getParameter("gender").equals("m");
		//傳回很多值  興趣
		String[] hobby = request.getParameterValues("hobby");
		
		response.setContentType("text/html; charset=UTF-8");
		//.getWriter();從他身上取得
		PrintWriter out = response.getWriter();
		//輸出
		out.printf("%s : %s : %s<br />", account, passwd, isMale?"Male":"Female");
		
		//將陣列字串印出
		for (String hh : hobby) {
			out.println(hh);
		}
		//確保輸出的動作(也可以不做）
		response.flushBuffer();
		
		
	}

	

}
