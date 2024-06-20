package tw.brad.tutor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//取得資料夾圖片 並可以讓他另存新檔
@WebServlet("/Brad17")
public class Brad17 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//取得資料夾裡的圖片路徑
		String source ="/Users/long/eclipse-workspace/bradweb/src/main/webapp/upload/14.jpg";
		
		//讀取圖片
		BufferedImage img = ImageIO.read(new File(source));
		Graphics2D g2d = img.createGraphics();
		
		//打上浮水印 藍色
		g2d.setColor(Color.BLUE);
		//font將文字打斜處理
		//該改文字樣式     (       ,粗體 ,多大）
		Font font1 = new Font(null, Font.BOLD, 100);
		AffineTransform af = new AffineTransform();
		//將文字順時針三十度 
		af.rotate(Math.toRadians(30));
		Font font2 = font1.deriveFont(af);
		
		
		
		
		//把字給畫出來    
		g2d.setFont(font2);
		//（要輸入的字,指定位置,指定位置）
		g2d.drawString("資策會論壇專屬\n歡迎盜連", 100, 200);
		
		//將圖片呈現上網頁上
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		//ImageIo另存新檔 並指定另存新檔到其他地方  （更改路徑即可）
		//ImageIO.write(img, "JPEG", new File("/Users/long/eclipse-workspace/name1/dir1/ok.jpg"));
		
		
	}

}