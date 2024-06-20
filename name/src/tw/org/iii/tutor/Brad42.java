package tw.org.iii.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


//串流Input文字
public class Brad42 {

	public static void main(String[] args) {
		
		//如果文字內容 在中間沒辦法一次取三個出現文字
		//所以這邊就是讓他一次取最大值 不管文字在哪都可以正常取出
		try {
			File f1 =new File("dir1/brad1.txt");
			FileInputStream fin =new FileInputStream(f1);
			byte[]buf=new byte[(int) f1.length()];
			//因為我臉盤就這麼大所以甚至不用寫while迴圈 就是直接取臉盆印臉盆
			fin.read(buf);
			System.out.println(new String (buf));
			
			
			fin.close();
			System.out.println("ok");
			
		}catch (Exception e) {
			System.out.println(e);
			}

		

	}

}
