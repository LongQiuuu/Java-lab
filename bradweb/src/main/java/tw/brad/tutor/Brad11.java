package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//將 Brad 11 產生的樂透值 加入到Brad  10  並顯示在網頁上
//這部分可以獨立運算並把值丟給另外一個網頁顯示
@WebServlet("/Brad11")
public class Brad11 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//接收參數
		String min = request.getParameter("min");
		//接收多個參數  肚子原本裡裝的都是物件 所以需要強制轉型回來(Integer)
		int range = (Integer)request.getAttribute("range");
		//產生樂透號碼
		try {
			int minValue = Integer.parseInt(min);
			response.getWriter().print((int)(Math.random()*range+minValue));
		}catch(Exception e) {
			response.getWriter().print("Ooop!");
		}
	}

}