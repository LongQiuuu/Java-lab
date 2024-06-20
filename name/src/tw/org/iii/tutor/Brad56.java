package tw.org.iii.tutor;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//TCP (連接導向,可靠傳遞)
//用戶端傳送文字
public class Brad56 {

	public static void main(String[] args) {
		try {
			//建立用戶端的socke 處理三方交握
			//Socket socket =new Socket(InetAddress.getByName("主機ＩＰ"),port);
			Socket socket =new Socket(InetAddress.getByName("10.0.103.138"),9999);
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
