package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// request 認識
//網路上面所有的傳遞 都是字元字串
@WebServlet("/Brad03")
public class Brad03 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Enumeration<String> names=request.getHeaderNames();
		
		while (names.hasMoreElements()) {
			//拿到header 參數名稱
			String name =names.nextElement();
			//拿到header 參數名稱裡面的值
			String value =request.getHeader(name);
			System.out.printf("%s:%s\n",name ,value);
			
		}
		
		//顯示網頁的值也可以改寫成下列
		PrintWriter out = response.getWriter();
		out.print("Hello2");
	}

	

}
