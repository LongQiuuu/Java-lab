package tw.org.iii.tutor;

import tw.org.iii.apis.TWID2;

public class Brad20 {

	public static void main(String[] args) {
		
		//判斷身分證是不是正確
		if (TWID2.checkTWID("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}

		//印出來看看
		System.out.println(new TWID2());
		System.out.println(new TWID2(true));
		System.out.println(new TWID2(4));
		System.out.println(new TWID2(false, 7));
		
		
		
		
		TWID2 myId = TWID2.createTWId("Y120239847");
		if (myId != null) {
			System.out.println(myId);
		}else {
			System.out.println("XX");
		}
	}

}
