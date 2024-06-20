package tw.org.iii.apis;

public class TWID {
	//static 不需要物件 只需要傳參數 就可使用 （可做為分類使用）
	public static boolean checkTWID (String id) {
		//1. 身分證長度為10碼
		//2. 第一碼 =>A-Z
		//3. 第二碼 =>1/2
		//4. 第三到十碼 =>0-9
		
		boolean isRight =false;
		//判斷字串長度
		if(id.length()==10) {
			
			//放入第一碼
			char c1 =id.charAt(0);
			//將所有英文放到字串
			String letters="ABCDEFGLIJKLMNOPQRSTUVWXYZ";
			//使用index(of)符合值的位置通常會大於1 來判斷輸入字元有沒有符合上面給的字串
			if(letters.indexOf(c1)!=-1) {
				
			}
			isRight=true;
		}
		
		//呼叫時可以看裡面字串長度是多少
		System.out.println(id.length());
		return isRight;
	}
}
