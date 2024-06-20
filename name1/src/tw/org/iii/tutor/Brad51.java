package tw.org.iii.tutor;

import java.util.LinkedList;

import javax.naming.LinkLoopException;

import tw.org.iii.apis.LineV2;



//強制轉換 除錯測試

public class Brad51 {

	public static void main(String[] args) {
		LinkedList<LineV2> obj = new LinkedList<>();
		Object obj1 = obj;
		if (obj1 instanceof LinkedList) {
			
		}
	}

}