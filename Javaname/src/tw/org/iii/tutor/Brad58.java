package tw.org.iii.tutor;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
//TCP (連接導向,可靠傳遞)
//伺服端接收圖檔
public class Brad58 {

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999)){
			System.out.println("wait...");
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			
		//內部檔案輸出串流  (將接收到的資料 內部輸出到指定資料夾裡）
		//取得對方ＩＰ
			String urip = socket.getInetAddress().getHostAddress();
			//將對方ＩＰ構成傳來的圖檔 並放在哪個資料夾
			String filename = String.format("dir2/%s.jpg", urip);
			//將收到的檔案輸出到資料夾建立
			BufferedOutputStream bout = 
					new BufferedOutputStream(
						new FileOutputStream(filename));
	
		//建立我一次可以讀的範圍容器大小
		byte[] buf = new byte[4*1024*1024]; int len;
		
		//我一次要讀的資料範圍
		while ( (len = in.read(buf)) != -1) {
			bout.write(buf, 0, len);
		}
		
		
		bout.flush();
		bout.close();
		
		in.close();
		socket.close();
		
		System.out.println("OK");
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
