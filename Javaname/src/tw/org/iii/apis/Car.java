package tw.org.iii.apis;

//所有建構式 第一道敘述句就是先將父類別建構式先初始化
//所有建構式 第一道敘述句就是先將祖宗八代的父類別先呼叫進來
public class Car extends Scooter {
	
	public Car() {
		//super() 呼叫父類別;
		super("");
	}

}
