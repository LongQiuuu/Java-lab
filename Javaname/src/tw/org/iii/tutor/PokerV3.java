package tw.org.iii.tutor;

//陣列字串排序 用ＡＰＩ外接
import java.util.Arrays;

public class PokerV3 {

	public static void main(String[] args) {
		//num張數
		int num=52;
		int []poker=new int[num];
		//取得52張牌
		for(int i = 0 ; i < num;i++) {
			poker[i]=i;}

		//從51 開始倒算  遞減模式
		for(int i =num-1;i>0;i--) {
			
			int rand = (int)(Math.random()*(i+1)); //原本i被減一  所以要加回來
			//開始做交換
			int temp =poker[rand];
			poker[rand]=poker[i];
			poker[i]=temp;
		}
		
		//全數列出看有沒有重複
		for (int card :poker) {
			System.out.println(card);
		}
		
		System.out.println("--------------");
		//發牌
		//第一層四個玩家 第二層13張牌
		int[][]players =new int [4][13];
		//用迴圈加陣列把牌 放到四位玩家裡面
		for (int i = 0 ; i < num ; i ++) {
			//第一格 取餘數 第二格除四
			players[i%4][i/4]=poker[i];
		}
		
		//給你看第一個玩家的牌來做驗證
		for (int card : players[1]) {
			System.out.println(card);
		}
		//定義花色陣列
		String[] sutis= {"黑桃","紅心","梅花","方塊"};
		//定義牌陣列 Ａ ~Ｊ Ｑ Ｋ
		String[] values= {"A  ","02  ","03  ","04  "
				,"05  ","06  ","07  ","08  ","09  ","10  ","J  ","Q  ","K  "};
		
		//先尋訪所有玩家
		for(int []player:players) {
			//陣列字串排序 用ＡＰＩ外接
			Arrays.sort(player);
			//尋訪各玩家手上的牌 card =牌的數字
			for(int card : player) {
				System.out.printf("%s%s  ",sutis[card/13],values[card%13]);
			}
			System.out.println();
		}
		
	}

}
