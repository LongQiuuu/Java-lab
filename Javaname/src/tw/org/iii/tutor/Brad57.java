package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//TCP (連接導向,可靠傳遞)
//用戶端傳圖檔
public class Brad57 {

	public static void main(String[] args) {
		try {
			//讀檔案內容進來
			File file =new File("dir1/coffee1.jpg");
			byte[]buf =new byte[(int)file.length()];
			FileInputStream fin=new FileInputStream(file);
			
			fin.read(buf);
			fin.close();
			
			//建立用戶端的socke 處理三方交握
			//Socket socket =new Socket(InetAddress.getByName("主機ＩＰ"),port);
			Socket socket =new Socket(InetAddress.getByName("10.0.103.79"),9999);
			//開始跟伺服端的socket對話 使用串流
			OutputStream out =socket.getOutputStream();
			//傳送給伺服端
			out.write("hello".getBytes());
			
			
			out.flush();
			out.close();
			socket.close();
			
			
		}catch (Exception e) {
			
			System.out.println(e);
		}
		
	}

}
