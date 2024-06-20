package tw.org.iii.tutor;


//以設計類別角度設計
//拋出例外就是不把程度寫死
public class Brad38 {

	public static void main(String[] args) {
		Bird b1=new Bird();
		System.out.println(b1.getLeg());
		try {
			b1.setLeg(2);
		}catch (Exception e) {
			
		}
		
		
	}

}

class Bird {
	private int leg;
	//設定鳥有幾隻腳 回傳參數
	//可能會拋出例外需要再方法加上throws Exceptio   throws=我有可能拋出 Exceptio＝拋出什麼的例外有很多種這邊可以替換
	int setLeg(int leg) throws Exception {
		
		if(leg>=0 && leg<=2) {
			this.leg=leg;
		}else {
			//把錯誤拋出去
			throw new Exception();
		}
		
		return this.leg;
	}
	
	int getLeg() {
		return this.leg;
	}
}

//改寫小鳥腳的例外
class BirdLegException extends Exception {
	@Override
	public String toString() {
		return "Bird Leg Excetopn";
	}
}