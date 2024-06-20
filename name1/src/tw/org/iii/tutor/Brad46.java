package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

//IO的串接
public class Brad46 {

	public static void main(String[] args) {
		try {
			//接三根管
//			FileInputStream fin = new FileInputStream ("dir1/ns1hosp.csv");
//			InputStreamReader in =new InputStreamReader (fin);
//			BufferedReader reader= new BufferedReader(in);
//			
			//也可以改寫成 接兩根管串接
			FileReader fr=new FileReader("dir1/ns1hosp.csv");
			BufferedReader reader= new BufferedReader(fr);
			
			
			
			String line;
			//第一列我不讀 
			reader.readLine();
			//readLine＝以行讀取不讀換列符號
			while ((line=reader.readLine())!=null) {
				
				//用逗號幫我隔開產生字串陣列
				String[]data=line.split(",");
				//我只想看到 2 5 6 7 的資料 以逗號來切割
				System.out.printf("%s:%s:%s:%S\n",data[2],data[5],data[6],data[7]);
				
				//驗證有沒有成功抓取
				//System.out.println((line));
				System.out.println("-----------");
			}
			
			//關檔
			reader.close();
		}catch (Exception e) {
			System.out.println(e);
			}
		
		

	}

}
