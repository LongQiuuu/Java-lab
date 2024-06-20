package tw.org.iii.tutor;

public class brad11 {

	public static void main(String[] args) {
		int p1,p2,p3,p4,p5,p6;
		p1=p2=p3=p4=p5=p6=0;
		
		//重複一百次亂數摋子
		for(int i=0;i<100;i++) {
			//亂數摋出骰子
			int point =(int)(Math.random()*6)+1;
			//計算個骰子出現次數
			switch (point) {
			case 1: p1++; break;
			case 2: p2++; break;
			case 3: p3++; break;
			case 4: p4++; break;
			case 5: p5++; break;
			case 6: p6++; break;
			}
		}
		
		System.out.printf("1點出現%d\n",p1);
		System.out.printf("2點出現%d\n",p2);
		System.out.printf("3點出現%d\n",p3);
		System.out.printf("4點出現%d\n",p4);
		System.out.printf("5點出現%d\n",p5);
		System.out.printf("6點出現%d\n",p6);
	}

}
