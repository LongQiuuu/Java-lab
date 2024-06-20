package tw.org.iii.tutor;

import tw.org.iii.apis.Bike;

public class Brad19 {

	public static void main(String[] args) {
		//在ＪＡＶＡ的世界裡 如果使用""會自動在記憶體產生出來 相當於ＮＥＷ 初始化
		String s1 = "brad";
		//若是相同字串 會同時指向同個記憶體
		String s2 = "brad";
		//來驗證看看 S1 S2 肚子裡是不是相同東西
		System.out.println(s1==s2); //true
		//在ＪＡＶＡ的世界裡 如果字串已經初始化 就無法再改變了 
		//若是硬要變更他會指向新的記憶體空間
		
		
		//NEW後面要接建構式 產出新的物件實體
		String s3=new String("brad");
		String s4=new String("brad");
		
		//因為我同時使用創建新的物件實體 所以他肚子裡面裝的東西不同
		System.out.println(s3==s4); //false
		
		//比較父類別是不是相同位址
		System.out.println(s1.equals(s3));//true
		
		Bike b1=new Bike();
		System.out.println(b1);//記憶體位置
		System.out.println(s2);
		
		//當我去Bike 改寫String新增之後
		//println會自動去抓取 String的值 所以當我沒有設定時他會抓記憶體位置
		System.out.println(b1);//speed is 0.000000
		
		//字串物件 (回傳字串的第一個字）
		System.out.println("ispan".charAt(0));//i
		
		//將s1的字串concat呼叫並在後面加上 hello 給s5
		String s5=s1.concat("hello");
		System.out.println(s5);//bradhello
		//但不會影響原本s1的值
		System.out.println(s1);//brad
	}

}
