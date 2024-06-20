package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad05")
public class Brad05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收前端取的的值
		String x=request.getParameter("x");
		String y=request.getParameter("y");
		//將字串改成數字
		int result =Integer.parseInt(x)+Integer.parseInt(y);
		//驗證看看有沒有收到
		System.out.printf("%s + %s= %d \n",x,y,result);
		//setContentType宣告以下的內容
		response.setContentType("text/html; charset=UTF-8");
		
		//將結果輸出到網頁上
		PrintWriter out = response.getWriter();
		out.printf("%s + %s = %d \n", x, y, result);
		//確保輸出的動作(也可以不做）
		response.flushBuffer();
	}

	

}
