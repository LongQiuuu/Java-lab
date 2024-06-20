package tw.org.iii.tutor;

public class Brad06 {

	public static void main(String[] args) {
		int year=2024;
		boolean isLeap=false;
		
		if(year%4==0) {
			if(year%100==0) {
				if(year%400==0) {
					isLeap=true;
				}else {
					isLeap=false;
				}
				
			}else {
				isLeap=true;
			}
		}else {
			isLeap=false;
		}
			
		System.out.printf("%d年為%s年",year,isLeap?"潤":"平");

	}

}
