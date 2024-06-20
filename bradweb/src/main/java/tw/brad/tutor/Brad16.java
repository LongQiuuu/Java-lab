package tw.brad.tutor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//後端畫圖 並呈現在網頁上
@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//設定一個變數來做可以顏色要圖多少
		int w, h; w= 400; h = 20;
		double rate = 0;	// 50 => 50%
		
		//再升級 依照輸入得參數來顯示要畫多少
		try {
			rate = Double.parseDouble(request.getParameter("rate"));
		}catch(Exception e) {}
		//這段話下去就是告訴系統 我下面都在處理有影像
		response.setContentType("image/jpeg");
		//建立寬為400 高為20 得影像物件實體
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		//拿取Graphics2D得物件實體
		Graphics2D g2d = img.createGraphics();
		
		
		//開始畫圖
		//設定顏色(黃色)
		g2d.setColor(Color.yellow);
		//將畫面顏色塗滿
		g2d.fillRect(0, 0, w, h);
		//設定顏色(紅色)
		g2d.setColor(Color.red);
		//只塗一半顏色
		g2d.fillRect(0, 0, (int)(w*rate/100), h);
		// Image    (記憶體的資料,格式,輸出去哪裡)
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
	}

}