package tw.org.iii.tutor;

public class Brad35 {

	public static void main(String[] args) {
		int a =10 ,b=0;
		int[] w=new int [3];
		//強制他印出
		try {
			System.out.println(a/b);//會產生執行時期拋出的例外
			System.out.println(w[3]);//會產生執行時期拋出的例外 (我沒陣列3的值
		//捕捉有關數學的例外
		}catch (ArithmeticException e) {
			System.out.println("oooP!");
		//捕捉有關陣列的例外
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("oooP2");
			
		//其他得錯誤由他捕捉  但若是把他改到第一位 全部都被他捕捉走了 下面錯誤捕捉就會失效
		}catch (RuntimeException e) {
			System.out.println("oooP3");
		}
		
		
		
		System.out.println("ok");
		
		double c =10.0 ,d=0;
		System.out.println(c/d); //Infinity 無限大
		
		double e =0 ,f=0;
		System.out.println(e/f); //NaN 
	}

}

//ArrayIndexOutOfBoundsExceptio 與ArithmeticException  不是直系血親 彼此間沒關係 所以順序對調也沒關差
//若是有直接關西順序需要注意