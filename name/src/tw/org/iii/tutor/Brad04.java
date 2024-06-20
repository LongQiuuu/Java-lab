package tw.org.iii.tutor;

public class Brad04 {

	public static void main(String[] args) {
		//產生亂數
		double temp=Math.random();
		
		//因Math.random只能取的0-1之間的數 這邊要亂數取得0~100 之間的數
		int score=(int)(temp*101);
		
				
		if (score>=90) {
			System.out.println("及格");
		}else {
			
			System.out.println("被當摟");
		}

	}

}
