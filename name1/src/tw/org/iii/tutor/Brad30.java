package tw.org.iii.tutor;


import java.util.LinkedList;

public class Brad30 {

	public static void main(String[] args) {
		LinkedList<String>names =new LinkedList <String>();
		names.add("brad");
		names.add(0,"MarK");
		names.add(1,"Andy");
		names.add("Eric");
		names.add("brad");
		
		//判斷裡面有多少元素
		System.out.println(names.size());
		
		//印出這些元素
		for(String name:names) {
			System.out.println(name);
		}
		//印出單一元素
		System.out.println(names.get(2));
	}

}
