package tw.org.iii.tutor;
//這邊是使用腳踏車
import tw.org.iii.apis.Bike;

public class Brad15 {
	
	public static void main(String[] args) {
		Bike b1= new Bike();
		
		//這邊引用類別
		//若這邊沒有放值 因為上面已經宣告Bike並完成初始化 
		//System.out.println(b1.speed);
		//就會先帶入double 預設0.0
		
		
		System.out.println(b1.getSpeed());
		
		b1.upSpeed();
		System.out.println(b1.getSpeed());
		//瘋狂加速
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		
		System.out.println(b1.getSpeed());
		
		b1.downSpeed();
		
	}

}
