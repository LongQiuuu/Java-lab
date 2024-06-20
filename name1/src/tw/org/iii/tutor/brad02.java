package tw.org.iii.tutor;

//外接掃瞄器功能
import java.util.Scanner;

public class brad02 {

	public static void main(String[] args) {
		//1. 輸入 
		//Scanner scanner=new Scanner()
		//Scanner 變數名稱＝建構 初始化 （輸入串流）
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("請輸入一個值");
		int x =scanner.nextInt();
		System.out.println("再輸輸入一個值");
		int y =scanner.nextInt();
		int r1 =x+y;
		int r2 =x-y;
		int r3 =x*y;
		int r4 =x/y;
		int r5 =x%y;
		
		//printf 格式化 ("帶入格式",帶入的值);
		// \n下一行
		System.out.printf("%d+%d=%d\n",x,y,r1);
		System.out.printf("%d-%d=%d\n",x,y,r2);
		System.out.printf("%d*%d=%d\n",x,y,r3);
		System.out.printf("%d/%d=%d...%d",x,y,r4,r5);

	}

}
