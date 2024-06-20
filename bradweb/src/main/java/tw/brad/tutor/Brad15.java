package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.BradUtils;

//引用自己寫的api 並輸出到網路上


@WebServlet("/Brad15")

public class Brad15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//從viewv1.html拿取運算結果
		String result = (String)request.getAttribute("result");
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//引用 BradUtils API
		String webPage = "NOT FOUND";
		try {
			webPage = BradUtils.loadView("viewv1");
			System.out.println("OK");
		}catch(Exception e) {}
		
		//印到網頁上
		out.printf(webPage, x, y, result);
		//確認輸出
		response.flushBuffer();
	}

}