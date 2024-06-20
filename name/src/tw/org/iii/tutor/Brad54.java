package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
//UDP (非連接導向,不可靠傳遞)      接收資料封包
public class Brad54 {

	public static void main(String[] args) {
		//建立無窮迴圈讓他可以一直接收封包
		while(true) {
			//建立接收封包信箱大小 開發者自己決定要多大
			byte[]buf=new byte[4*1024];
			try {
				//建立插座 但因為要接收封包 所以後面要加哪個ＰＯＲＴ
				DatagramSocket socket = new DatagramSocket(8888);
				//建立信箱實體
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				
				System.out.println("wait...");
				//socker 接收封包
				socket.receive(packet);
				//socket插座關閉
				socket.close();
				
				//資料一定在封包裡面 看看是誰寄封包給我 抓取對方主機名稱跟iP
				String urip = packet.getAddress().getHostAddress();
				//解析封包  收到的是byte 
				byte[] data = packet.getData();
				//從封包取得這次的長度
				int len = packet.getLength();
				
				//String mesg = new String(資料, 從零開始, 封包長度);
				String mesg = new String(data, 0, len);
				//去頭去尾來做判斷 傳來的封包裡面有BYE這個 即跳出迴圈
				System.out.printf("%s : %s\n" , urip, mesg);
				if (mesg.trim().equals("bye")) {
					break;
				}
				
				
				}catch (Exception e) {
					System.out.println(e);
				}
		}
	}

}

