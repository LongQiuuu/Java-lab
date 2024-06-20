package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.MyModel;
//扮演 Controller 角色

//抓取MyModel的運算

//Brad14面對客戶

//Brad15負責處理邏輯 並將畫面回傳到Brad14
//viewv1 網頁排版美化
//BradUtils  讀取網頁字串
//前後端分離實際運用 
@WebServlet("/Brad14")
public class Brad14 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//1.接收參數
		//取得參數
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		//2.運算
		//將apis 裡面得 MyModel .java的類別引用到這來做運算
		MyModel myModel = new MyModel(x, y);
		String result = myModel.plus();
		//將剛剛的結果夾帶出去
		//因為一開始沒打數字的時候會顯示NULL 畫面會不好看 所以這邊做個判斷式 如果是null 則回傳空白值
		if (x == null && y == null) {
			request.setAttribute("result", "");
			request.setAttribute("x", "");
			request.setAttribute("y", "");			
		}else {
			request.setAttribute("result", result);
			request.setAttribute("x", x);
			request.setAttribute("y", y);
		}
		
		
		//3.呈現view
		//將他分支出去
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad15");
		dispatcher.forward(request, response);
	}

}