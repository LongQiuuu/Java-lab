package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.TreeSet;

public class Brad29 {

	public static void main(String[] args) {
		HashSet<Integer> set =new HashSet<>();
		set.add(123); //成功加入
		//set.add("Brad"); 失敗 因為不是放int
		set.add(12); //成功加入
		
		//來應用在大樂透號碼
		HashSet<Integer> lottery =new HashSet<>();
		
		while(lottery.size()<6) {
			lottery.add((int)(Math.random()*49+1));
		}
		System.out.println(lottery);
		
		
		//想要讓他有排序功能 僅需將HashSet 資料結構 更改為 Treeset
		TreeSet<Integer> lottery2 = new TreeSet<>();
		
		while(lottery2.size()<6) {
			lottery2.add((int)(Math.random()*49+1));
		}
		System.out.println(lottery2);
		
		
		
	}

}
