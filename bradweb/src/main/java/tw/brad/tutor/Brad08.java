package tw.brad.tutor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/Brad08")
//招數一 針對這個類別處理檔案上傳 @MultipartConfig(檔案放在特定的地方)
@MultipartConfig(location = "/Users/long/eclipse-workspace/bradweb/src/main/webapp/upload")
public class Brad08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//呼叫得時候會回傳 Part的物件實體
		Part part = request.getPart("upload");
		
		//檢查一下這個物件有什麼資訊
		System.out.println(part.getName());
		System.out.println(part.getSize());
		//送上來的名稱
		System.out.println(part.getSubmittedFileName());
		//
		System.out.println(part.getContentType());
		
		//設立判斷式  成立就上傳到指定的日蝕資料夾
		if(part.getSize()>0) {
			//上傳到指定的日蝕資料夾
			part.write(part.getSubmittedFileName());
			System.out.println("OK");
		}
		
		
	}

}
