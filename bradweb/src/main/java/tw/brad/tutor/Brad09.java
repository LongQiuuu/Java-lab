package tw.brad.tutor;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet("/Brad09")
//招數一 針對這個類別處理檔案上傳 @MultipartConfig(檔案放在特定的地方)
@MultipartConfig(location = "/Users/long/eclipse-workspace/bradweb/src/main/webapp/upload")
public class Brad09 extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//多重檔案 呼叫得時候會回傳Collection   
		Collection<Part> parts = request.getParts();
		//用尋訪方式將所有接收到的資料傳到指定資料夾
		for (Part part:parts) {
			//可以這樣直接上傳
			//System.out.println(part.getName());
			//也可以增加判斷式在上傳
			if (part != null && part.getName().equals("upload") && part.getSize() > 0) {
				part.write(part.getSubmittedFileName());
			}
		}
	}
}
