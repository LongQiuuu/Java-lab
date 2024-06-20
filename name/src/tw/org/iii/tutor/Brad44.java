package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

//圖片複製貼上一次讀全部
//這種方法的執行效能會比較快
public class Brad44 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			//複製
			FileInputStream fin = new FileInputStream("dir1/coffee1.jpg");
			//貼上
			FileOutputStream fout = new FileOutputStream("dir2/coffee3.jpg");
			
			//一次讀 4*1024
			int len; byte[] buf = new byte[4*1024];
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			//開檔
			fout.flush();
			//關檔
			fout.close();
			//關檔
			fin.close();
			System.out.println("finish");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(System.currentTimeMillis() - start);
		
		
		


	}

}
