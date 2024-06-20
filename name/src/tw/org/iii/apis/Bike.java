package tw.org.iii.apis;

import java.io.Serializable;

//這邊設計腳踏車

//當你沒寫父類別繼承時 系統會自動幫你帶入 extends Object)
//public class Bike extends Object {}

//任何一個類別 想要將他做序列化的動作需要宣告他可序列化Serializable 
public class Bike implements Serializable {
	//宣告速度 可是這樣外界無法存取需加上public 
	//public double speed;
	
	//不能讓人從外去更改速度 要把public 更改private
	//這樣速度就只能從這邊存取與修改 就是讓這個方法只能這內部修改
	//private double speed;
	
	//若要讓子類別來延伸繼承將private 更改為protected 變成保護級
	protected double speed;
	
	//void 方法沒有傳回值
	//定義一個方法 (加速度）
	public void upSpeed() {
		//若是速度小於一 我先將速度更改為一
		speed=speed<1? 1:speed*1.2;
	}
	//定義一個方法 (減速度） 
	public void downSpeed() {
		//若是速度小於一 我先將速度更改為0
		speed=speed<1?1:speed*0.7;
	}
	
	//加裝 偵測速度功能
	public double getSpeed() {
		return speed;
	}
	
	//設定String
	public String toString() {
		return String.format("speed is %f",speed);
	}
	
}
