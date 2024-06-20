package tw.org.iii.tutor;

public class Brad25 {

	public static void main(String[] args) {
		//因為我下面使用抽象類別 所以無法直接建構出物件實體
		//Brad251 obj1 = new Brad251();
		
		//所以宣告251 實作由252來執行產生物件實體
		Brad251 obj2 = new Brad252();
		Brad251 obj3 = new Brad253();
		//多型的表示是由父類別主導
		obj2.m2();
		obj3.m2();
		

	}

}
//使用抽象類疊時機  251 是怪物  252 就是怪物的攻擊方式
//內容有抽象發法 所以前面要宣告是抽象類別
//無法直接建構出物件實體
abstract class Brad251 {
	Brad251(){System.out.println("Brad251()");}
	void m1 () {System.out.println("Brad251: m1()");}
	//沒有實作的方法就是抽象方法 所以前面要宣告 abstract
	abstract void m2();
}

class Brad252 extends Brad251{
	Brad252(){System.out.println("Brad252()");}
	void m2(){System.out.println("Brad252: m1()");}
}

class Brad253 extends Brad251{
	Brad253(){System.out.println("Brad253()");}
	void m2(){System.out.println("Brad253: m1()");}
}