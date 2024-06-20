package tw.org.iii.tutor;
import tw.org.iii.apis.Car;

public class Brad17 {

	public static void main(String[] args) {
		//為什麼我一開始沒建立建構式可是他可以帶出 父類別的紅色
		//在ＪＡＶＡ的世界所有類別都有建構式
		//若沒有特別設定建構式 程式會幫你找父類別 沒有傳參數的建構式 來幫你放入
		Car c1 = new Car();
		System.out.println(c1.getColor());
		
	}

}
