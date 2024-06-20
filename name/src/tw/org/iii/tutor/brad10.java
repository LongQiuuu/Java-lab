package tw.org.iii.tutor;

public class brad10 {

	public static void main(String[] args) {
		//整數陣列  陣列也算物件 所以要初始化 加ＮＥＷ
		int [] ary = new int[3];
		//知道ary裡面有幾格元素個數
		System.out.println(ary.length);
		
		ary[0]=123; ary[2]=12;
		
		//第一種寫法 跑完陣列所有元素並列印出來
		for (int i=0 ;i<ary.length;i++) {
			System.out.println(ary[i]);
		}
		System.out.println("-------------");
		
		//第二種寫法 跑完陣列所有元素並列印出來
		for(int v :ary) {
			//每跑一次陣列會將元素賦予v並列印出v
			System.out.println(v);
		}
		
	}

}
