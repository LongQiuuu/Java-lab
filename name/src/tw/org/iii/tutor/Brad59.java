package tw.org.iii.tutor;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

//URL   
//跟Http 取的網頁原始碼
public class Brad59 {

	public static void main(String[] args) {
		
		try {
			URL url =new URL("https://www.iii.org.tw");
			URLConnection urlConnection =url.openConnection();
			
			//為了使用它的功能 強制轉型
			HttpsURLConnection conn =(HttpsURLConnection)urlConnection;
			
			//取得頁面原始碼
			BufferedReader br =new BufferedReader (new InputStreamReader(conn.getInputStream()));
			
			String line ;
			while ((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
			br.close();
			
		}catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
