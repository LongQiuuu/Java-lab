package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//TCP (連接導向,可靠傳遞)
//伺服端Socket 接受文字
public class Brad55 {

	public static void main(String[] args) {
		//建立四服端的Socket
		try(ServerSocket server =new ServerSocket(9999)){
			
			System.out.println("wait...");
			//server.accept(); 正在等候 一但等到就是三方連結 把訊息傳回到socke
			Socket socket= server.accept();
			//接收用戶端的socket
			InputStream in = socket.getInputStream();
	
			//接收一段串流
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			//read僅接收第一段 read
			String line = br.readLine();
			//印出接收到的
			System.out.println(line);
			
			in.close();
			socket.close();
			
			System.out.println("ＯＫ");
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
