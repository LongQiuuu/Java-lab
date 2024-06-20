package tw.org.iii.tutor;

import tw.org.iii.apis.Scooter;

public class Brad16 {

	public static void main(String[] args) {
		//new Scooter產生物件實體記憶體空間 後方是 對既有物件初始化
		//將指定顏色參數放入"white （白色）"
		Scooter s1 = new Scooter("white") ;
		
		s1.upSpeed();
		s1.upSpeed();
		System.out.println(s1.getSpeed());
		
		//來將檔位功能加入s1.chGear(我想放入的檔位)
		s1.chGear(2);
		
		s1.upSpeed();
		s1.upSpeed();
		System.out.println(s1.getSpeed());

		
		//來看看是什麼顏色的摩托車
		System.out.println(s1.getColor());
	}

}
