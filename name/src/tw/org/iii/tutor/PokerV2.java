package tw.org.iii.tutor;

public class PokerV2 {

	public static void main(String[] args) {
		//開始執行這段程式需要多少秒 （千分之一秒）
		long start=System.currentTimeMillis();
		//總共有52張牌
		int [] poker =new int[52];
		//在迴圈宣告外面會接收不到所以在外面宣吿
		boolean isRepeat;
		int temp;
		
		for(int i=0;i<poker.length;i++) {	
			do {
				//產出52個亂數
				 temp=(int)(Math.random()*52);
				
				//但因為亂數有可能會產生重複的值 所以建立檢察機制
				 isRepeat=false; //如果重複這個值就會變true
				for(int j=0 ; j<i;j++) {
					if(temp==poker[j]) {
						//重複了跳出迴圈
						isRepeat=true;
						break;
					}
				}
				
			}while(isRepeat);
			//當他若是不重複 執行下列
			poker[i]=temp;
			System.out.println(poker[i]);
					
		}
		
		//印出執行這段程式需要多少秒 （千分之一秒）
		System.out.println(System.currentTimeMillis()-start);
	}

}
