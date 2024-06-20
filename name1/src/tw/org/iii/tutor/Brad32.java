package tw.org.iii.tutor;

import java.util.HashMap;
import java.util.Set;
//資料結構 MAP應用
public class Brad32 {

	public static void main(String[] args) {
		//Hashmap<key,valuet>
		HashMap<String,Object> map =new HashMap<String,Object>();
		//放入資料
		map.put("name", "Brad");
		map.put("age", 18);
		map.put("weight", 70.5);
		//印出指定名稱來看
		System.out.println(map.get("age"));
		
		//set 不重複沒有順序性
		Set<String> keys=map.keySet();
		//印出資料結構所有元素
		for(String key:keys) {
			System.out.println(key+":"+map.get(key));
		}
		
	}

}
