package tw.org.iii.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

//IP認識   TCP (連接導向,可靠傳遞)  UDP (非連接導向,不可靠傳遞)      識傳遞交換資料
public class Brad52 {

	public static void main(String[] args) {
		try {
			//拿到IP的物件實體
			//getByNome("主機名稱 只要格式正確就可以正確印出 不管有沒有這台主機");
			InetAddress ip = InetAddress.getByName("10.0.103.79");
			//印出IP
			System.out.println(ip.getHostAddress());
		}catch(UnknownHostException e) {
			System.out.println(e);
		}
		
	}

}
