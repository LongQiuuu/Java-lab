package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


//串流Input數字
//Input 適用byte
public class Brad41 {

	public static void main(String[] args) {
		
		try {
			FileInputStream fin =new FileInputStream("dir1/brad1.txt");
			//讀取裡面的byte第一個 再readu 一次就會指向第二個 以此類推
//			int c=fin.read();
//			System.out.println(c);
			
			//可是這樣太慢了我想一次查所有的內容
			int b;
			//.read的語法是當值到-1就是檔案內容的最後了
			while ((b=fin.read())!=-1) {
				//因為原本轉出來的是byte 所以將它改成char
				System.out.print((char)b);
			}
			
			//但是如果資料內容是中文字 中文字取的byte 不太一樣需要改寫
			//一個中文字三個byte
			int len; byte[]buf=new byte[3];
			//.read的語法是當值到-1就是檔案內容的最後了
			while ((len=fin.read(buf))!=-1) {
				//因為原本轉出來的是byte new String (一次取三個,從哪裡開始,讀到多少取多少)
				System.out.print(new String (buf,0,len));
			}
			
			
			fin.close();
			System.out.println("ok");
			
		}catch (Exception e) {
			System.out.println(e);
			}

		

	}

}
