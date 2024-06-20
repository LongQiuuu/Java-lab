package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//串流 Output
public class Brad40 {

	public static void main(String[] args) {
		String data ="1234567";
		//將字串改成byte陣列
		byte[] buf =data.getBytes();
		try {
			//再dir1資料夾創立一個本來沒有的文件 若檔案本來就在就維持不動
			//若是不希望每次寫上去的檔案都把複寫蓋掉 僅需在後面加上true 那下面加入的文字都會維持 不會被覆蓋掉
			FileOutputStream fout =new FileOutputStream ("dir1/brad1.txt",true);
			//在文件寫入訊息 以byte為單位
			fout.write(97);
			fout.write(98);
			fout.write(99);
			fout.write(100);
			
			//寫入文字字串
			fout.write(buf);
			//開檔
			fout.flush();
			//關檔
			fout.close();
			//如果沒有出意外就會跑出ＯＫ
			System.out.println("OK");
		
//		} catch(FileNotFoundException e) {
//			//建議還是要印出來看看 不要留白 才知道意外有沒有發生
//			System.out.println(e);
//		//如果IOException 所有例外都會被他捕捉 所以這個要放下面
//		} catch(IOException e) {
//			System.out.println(e);
//		}
		//若理解上面觀念 其實可以直接用抓最大的例外的 就可以讓上面例外都不用寫了
		}catch (Exception e) {
		System.out.println(e);
		}

	}

}
