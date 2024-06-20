package tw.org.iii.tutor;

import java.awt.FontFormatException;

public class Brad39 {

	public static void main(String[] args) {
		//當下面方法都不處理 就只能最後自己處理
		try {
			m3();
		} catch (Exception e) {
		}
		
		m4(-3);
	}
	//堆疊例外處理
	static void m1 ()throws Exception {
		throw new Exception();
	}
	static void m2 () throws Exception{
		m1();
	}
	static void m3 () throws Exception{
		m2();
		
	//當上面方法都不處理 就只能最後自己處理
	}
	
	//方法宣告拋出 要加Ｓ  拋出物件實體不用加Ｓ
	static int m4 (int a) {
		System.out.println("m4()");
		
		try {
			if (a>0) {
				System.out.println("OK");
			}else {
				m1();
				System.out.println("錯誤1");
			}
			System.out.println("錯誤2");
		}catch (Exception e) {
			System.out.println(e);
			//return 0;
			//可以移除這行註解 看看finally功能
			
		//finally最後要做什麼事  就算程式提早離開也會執行finally
		}finally {
			
		}
		System.out.println("before return");
		return a;
		
		
	}

}

// Exception 拋出異常範圍比較大
//FontFormatException 拋出範圍比較小

//所以當使用extends繼承時 拋出的範圍不能比父類別大
class Brad391{
	void m1()throws Exception{}
	void m1(int a) {}
}

class Brad392 extends Brad391{
	void m1()throws FontFormatException  {}
}

class Brad393 extends Brad392{
	void m1() {}
}