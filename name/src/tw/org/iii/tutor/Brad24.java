package tw.org.iii.tutor;

public class Brad24 {

	public static void main(String[] args) {
		Brad242 obj = new Brad242();
		obj.m2();

	}
}

//父類別
class Brad241{
	void m1 () {
		System.out.println("Brad241: m1()");
	}
	
	//方法名稱一樣 個數型別一樣
	protected Object m1 (int a) {
		System.out.println("Brad241:m1()int");
		return null;
	}
	
}
//子類別
class Brad242 extends Brad241{
	void m1 () {
		//用super 物件方法來呼叫 永遠只認父類別
		super.m1();
		System.out.println("Brad242: m1()");
	}
	
	void m2() {
		super .m1(); //叫爸爸的
		this.m1(); //叫自己子
	}
	//方法名稱一樣 個數型別一樣 這邊要注意存取權限要大於等於父類別的
	//且後方物件權限也要大於父類別
	public String m1 (int a) {
		System.out.println("Brad241:m1()int");
		return null;
	}
}

class Brad243 extends Brad242{
	void m1 () {
		//用super 物件方法來呼叫 永遠只認父類別
		super.m1();
		
	}
}