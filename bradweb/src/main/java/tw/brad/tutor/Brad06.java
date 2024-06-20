package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//這邊前後端不分離 都是後端來做處理
@WebServlet("/Brad06")
public class Brad06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//為了保留原本的值 做宣吿
		String span = "", x = "", y = "";
		int result = 0;
		String op = "";
		
		
		
		if (request.getParameter("x") != null) {
				//接收前端取的的值
				x = request.getParameter("x");
				y = request.getParameter("y");
				op = request.getParameter("op");
				switch (op) {
					case "1":
						result = Integer.parseInt(x) + Integer.parseInt(y);
						span = String.format("<span>%s</span>", result+"");
						break;
					case "2":
						result = Integer.parseInt(x) - Integer.parseInt(y);
						span = String.format("<span>%s</span>", result+"");
						break;
					case "3":
						result = Integer.parseInt(x) * Integer.parseInt(y);
						span = String.format("<span>%s</span>", result+"");
						break;
					case "4":
						result = Integer.parseInt(x) / Integer.parseInt(y);
						int mod = Integer.parseInt(x) % Integer.parseInt(y);
						span = String.format("<span>%s</span>", result+ " ... " + mod);
						break;
				}
			}
				
		
		
		response.setContentType("text/html; charset=UTF-8");
		//.getWriter();從他身上取得
		PrintWriter out = response.getWriter();
		
		//將html程式碼加到網頁上
		out.append("<meta charset='UTF-8'>")
		.append("<form>")
		//為了點擊按鈕後 還可以保留原值
		.append(String.format("<input name='x' value='%s' />", x))
		//下拉式選單
		.append(" <select name='op'>")
		//value預設值
		.append(String.format("<option value='1' %s>+</option>", op.equals("1")?"selected":""))
		.append(String.format("<option value='2' %s>-</option>", op.equals("2")?"selected":""))
		.append(String.format("<option value='3' %s>x</option>", op.equals("3")?"selected":""))
		.append(String.format("<option value='4' %s>/</option>", op.equals("4")?"selected":""))
		.append("</select> ")
		//為了點擊按鈕後 還可以保留原值
		.append(String.format("<input name='y' value='%s' />", y))
		.append("<input type='submit' value='='>")
		.append(span)
		.append("</form>");
		
		//確保輸出的動作(也可以不做）
		response.flushBuffer();
	}

	
}
