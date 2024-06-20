package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.org.iii.apis.Bike;

//解序列化
public class Brad48 {

	public static void main(String[] args) {
		
		try {
			ObjectInputStream oin= new ObjectInputStream (new FileInputStream("dir1/brad.obj"));
					//將他讀進來
			Object obj =  oin.readObject();			
			//判斷你肚子是不是Bike	
			if (obj instanceof Bike) {
				//是的話我就將你放進來
				Bike b1 = (Bike)obj;
				System.out.println(b1);
			}else {
				System.out.println("XX");
			}
			oin.close();
			
					
		}catch (Exception e) {
			System.out.println(e);
			}
		
	}

}
