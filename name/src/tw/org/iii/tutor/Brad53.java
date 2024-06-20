package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDP (非連接導向,不可靠傳遞)      傳遞交換資料封包
public class Brad53 {

	public static void main(String[] args) {
		//想要寄出的文字
		String mesg = "Hello, World";
		//資料
		byte[] data = mesg.getBytes();
		
		try {
			//建立插座
			DatagramSocket socket = new DatagramSocket();
			//建立封包  （資料 ,從零開始 ,資料長度）   getByName(資料要去哪裡),8888 = port 前後門;
			//port 任何TCP UDP 都會用到 可以理解成服務櫃檯 進去找他他會幫你執行服務
			DatagramPacket packet = new DatagramPacket(
					data, 0, data.length,
					InetAddress.getByName("10.0.103.79"), 8888);
			//讓socket把封包送出去
			socket.send(packet);
			//socket關閉
			socket.close();
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
	}

}
