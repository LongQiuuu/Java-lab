package tw.org.iii.tutor;

public class Brad26 {

	public static void main(String[] args) {
		Brad263 obj1 =new Brad263();
		Brad261 obj2 =new Brad263();
		Brad262 obj3 =new Brad263();
		

	}

}

//這章與類別無關
//interface 介面   定義規格
//只要是在介面裡面的方法都是抽象的 就是在定義規格
//介面裡面通通沒有實作
//JAVA 世界 介面的存取修飾字 都是公開的public 
//方法也全部是公開的public 
interface Brad261{
	void m1 ();
	void m2 ();
	
}

interface Brad262{
	void m3 ();
	void m4 ();	
}
//將261 實作出來implements
//規格可以實作多個
class Brad263 implements Brad261,Brad262{
	//所以這邊要新增公開
	public void m1(){}
	public void m2 (){}
	
	public  void m3 () {}
	public  void m4 () {}
}

//將261 262 涵蓋進去
interface Brad264 extends  Brad261,Brad262{
	void m5 ();

}
class Brad265 implements Brad264{
	public void m1 (){}
	public void m2 (){}
	
	public  void m3 () {}
	public  void m4 () {}
	
	public  void m5 () {}

}


