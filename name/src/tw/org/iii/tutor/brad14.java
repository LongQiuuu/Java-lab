package tw.org.iii.tutor;

public class brad14 {

	public static void main(String[] args) {
		int c=10 , d=3;
		//基本交換
		int tmp=c;
		c=d;
		d=tmp;
		
		
		System.out.printf("a=%d,b=%d\t",c,d);
		
		//進階交換(適用於整數）
		int a=10 , b=3;
		
		a=a+b; //a=13
		b=a-b; //b=10
		a=a-b; //a=3
		System.out.printf("a=%d,b=%d\t",a,b);	
		
		//再來一格互換
		int e=10 , f=3;
		
		e=e^f; 
		f=e^f; 
		e=e^f; 
		System.out.printf("a=%d,b=%d",a,b);
	}

}
