package tw.org.iii.apis;
//製作一個摩托車的功能

//extends = 延伸  意思為把原來的Bike 繼承到Scooter

public class Scooter extends Bike {
	
	//新增檔位功能  一開始習慣先設為僅本類別使用private
	private int gear;
	
	//新增摩托車顏色屬性
	private String color;
	
	//建構式 (永遠沒有return功能）
	
//	public Scooter() {
//		color ="rad";
//	}
	
	//在建構式裡面指定顏色
	public Scooter(String color) {
		//super (); 沒寫會自動幫你帶入 抓取父類別
		this.color=color;
	}
	
	//讓你知道什麼顏色的魔拖車
	public String getColor() {
		return color;
	}
	
	//更改檔位public int chGear (傳遞參數)
	public int chGear (int gear) {
		//因為檔位不會小於零 並限制最高檔位為四檔
		
		if (gear >=0 && gear <=4) {
			//故意將參數的gear 取名跟檔位gear一樣
			//那需要使用this  this.gear(檔位）=gear （參數）;
			this.gear=gear;
		}
		//跑完判斷式傳回現在檔位
		return this.gear ;
	}
	
	//繼承Bike的加速度
	public void upSpeed() {
		//Override 單一繼承父類別
		//speed=speed<1? 1:speed*1.2 *檔位;
		speed=speed<1? 1:speed*1.2 *gear;
			
	}
}
