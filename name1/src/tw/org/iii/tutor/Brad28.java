package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.Iterator;

public class Brad28 {

	public static void main(String[] args) {
		//HashSet 裡面只能裝物件
		HashSet set =new HashSet();
		//相同物件
		set.add("Brad");//字串
		set.add("Brad");//字串
		set.add(new String("Brad"));//字串
		
		//他在丟進去之前自動包裝成物件
		set.add(12); // auto-boxing int=>Integer
		set.add(12.3);// double=>Double
		
		//印出裡面有多少元素
		System.out.println(set.size());
		
		//迭代器器功能 此種方法只能用一次
		Iterator it = set.iterator();
		while (it.hasNext()) {
					
			Object obj = it.next();
			//判斷是不是什麼物件
			if (obj instanceof String) {
				System.out.println("String:" + obj);
			}else if (obj instanceof Integer) {
				System.out.println("Integer: " + obj);
			}else if (obj instanceof Double) {
				System.out.println("Double: " + obj);
			}else {
				System.out.println("XX");
			}
		}
		
		
		//印出裡面的元素
		System.out.println(set);
		System.out.println("-------------");
		
		//任何一物件 他可實作可迭代 他可直接執行下列方法 （這種方法可以用很多次）
		for (Object obj : set) {
			if (obj instanceof String) {
				System.out.println("String:" + obj);
			}else if (obj instanceof Integer) {
				System.out.println("Integer: " + obj);
			}else if (obj instanceof Double) {
				System.out.println("Double: " + obj);
			}else {
				System.out.println("XX");
			}
		}
			
	}
	
}
