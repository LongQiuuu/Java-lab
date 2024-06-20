package tw.brad.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.brad.apis.MemberDB;

//進行註冊的行為
@WebServlet("/Register")
public class Register extends HttpServlet {
	//宣告擁有物件實體
	private MemberDB memberDB;
	
	public Register() {
		//因為剛剛都把例外丟出 所以這邊要處理
		try {
			memberDB=new MemberDB();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String realname = request.getParameter("realname");
		
		try {
			//是否存在這組帳號
			if (!memberDB.isAccountExist(account)) {
				//呼叫帳號密碼
				if (memberDB.addNew(account, passwd, realname)>0) {
					//新增成功幫我轉向到Brad24.JSP
					response.sendRedirect("brad24.jsp");
				}else {
					//新增失敗幫我轉向到brad23.html
					response.sendRedirect("brad23.jsp?errType=1");
				}
			}else {
				response.sendRedirect("brad23.jsp?errType=2");
			}
			
		}catch(Exception e) {
			//產生例外幫我顯示錯誤頁面  （顯示代碼 顯示字串）
			response.sendError(500, "Server Busy");
			System.out.println(e);
		}
		

	}

	
}