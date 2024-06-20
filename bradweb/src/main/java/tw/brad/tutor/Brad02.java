package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad02")
public class Brad02 extends HttpServlet {
	
	//永遠只有一個物件 就算重新整理也只會有一次
	public Brad02() {
		System.out.println("brad02 ()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//請求來的時候做回應 (這是簡寫）
		//response.getWriter().append(" V2 Served at: ").append(request.getContextPath());
		//上述完整可以拆寫成
		PrintWriter  pw=response.getWriter();
		pw.append("hello word");
		//重新整理會重複運行
		System.out.println("ok");
	}

	
	

}
