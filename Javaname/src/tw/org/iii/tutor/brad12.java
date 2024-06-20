package tw.org.iii.tutor;

public class brad12 {

	public static void main(String[] args) {
		int []p=new int[6]; //[0]=0...[5]=0
		int point=0;
		
		//重複一百次亂數摋子
		for(int i=0;i<100;i++) {
			//亂數摋出骰子
			 point =(int)(Math.random()*6)+1; //1~6
			//計算個骰子出現次數
			p[point-1]++;
			
		}
		
		for(int i =0 ; i<p.length;i++) {
			System.out.printf("%d點出現%d次\n",i+1,p[i]);
		}
		
		
	}

}
