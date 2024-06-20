package tw.brad.tutor;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此章節來討論伺服器啟動的父類別呼叫相關
@WebServlet("/Brad04")
public class Brad04 extends HttpServlet {
	
    public Brad04() {
    	System.out.println("Brad04()");
    }

	
    @Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig)");
		//super.init(config);
	}
    
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
		super.init();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
		System.out.println("service(1)");
		super.service(req, res);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("service(2)");
		//判斷頁面傳送出來的請求
		
		
		super.service(req, resp);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("do GET");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post");
	}

}
