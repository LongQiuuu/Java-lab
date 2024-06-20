package tw.org.iii.tutor;

public class brad99 {


		public static void main(String[] args) {
			//我有幾個行
			final int ROW=2;
			//我有幾段
			final int COL=4;
			//從二開始
			final int START=2;
			
			
			//做第二層6~9
			for(int z=0; z<ROW ;z++) {
				//做第一層2~5
				for(int y=1 ; y<=9; y++) {
					for (int x = START; x <= START+COL-1; x++) {
						
						//配合第二層6~9新增新得變數
						int newx = x+z*COL;
						int r = newx * y;
						System.out.printf("%d x %d = %d\t", newx,y, r);
					}
					//跑完2-5 跑一個分行
					System.out.println();
					
				}
					//第一層跑完跑加入-----
					System.out.println("------------");
				
			}
			
		}
	}