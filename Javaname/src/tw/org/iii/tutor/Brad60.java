package tw.org.iii.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

//URL   
//跟Http 取得圖片並建立在我得資料夾
public class Brad60 {

	public static void main(String[] args) {
		
		try {
			//提出請求
			URL url =new URL("https://p2.bahamut.com.tw/B/2KU/75/67946dfa9d725b67dde402d82b1pp1n5.JPG");
			URLConnection urlConnection =url.openConnection();
			
			//為了使用它的功能 強制轉型
			HttpsURLConnection conn =(HttpsURLConnection)urlConnection;
	
			//取得圖片
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			//將收到的圖片建立並放到指定資料件
			BufferedOutputStream bout = 
					new BufferedOutputStream(
						new FileOutputStream("dir2/gamer.jpg"));
			
			//建立我一次可以讀的範圍容器大小
			byte[] buf = new byte[4*1024*1024]; int len;
			
			//我一次要讀的資料範圍
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
			
			bin.close();
			
	
			
		}catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
