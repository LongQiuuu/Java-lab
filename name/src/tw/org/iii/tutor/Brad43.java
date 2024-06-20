package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//圖片複製貼上 這種寫法執行時間較長
public class Brad43 {

	public static void main(String[] args) {
		//測試執行時間
		long start = System.currentTimeMillis();
		try {
			//複製
			FileInputStream fin = new FileInputStream("dir1/coffee1.jpg");
			//貼上
			FileOutputStream fout = new FileOutputStream("dir2/coffee1.jpg");
			
			int d;
			while ((d = fin.read()) != -1) {
				fout.write(d);
			}
			//開檔
			fout.flush();
			//關檔
			fout.close();
			//關檔
			fin.close();
			System.out.println("finish");
			
		}catch (Exception e) {
			System.out.println(e);
			}
		
		//測試執行時間
		System.out.println(System.currentTimeMillis() - start);
	}

}
