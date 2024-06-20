package tw.org.iii.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tw.org.iii.apis.Bike;

//物件序列化 out  把怎麼物件寫出去
public class Brad47 {

	public static void main(String[] args) {
		//如果要將BIKE 序列化 需要去原檔需告要可以序列化implements Serializable
		Bike b1=new Bike();
		b1.upSpeed();
		//try 如果加括號 就是(可自動關閉語法)
		try (FileOutputStream fout= new FileOutputStream ("dir1/brad.obj");
			 ObjectOutputStream oout= new ObjectOutputStream(fout);	){
			
			
			
//			FileOutputStream fout= new FileOutputStream ("dir1/brad.obj");
//			ObjectOutputStream oout= new ObjectOutputStream(fout);
			//可以將上列寫成一排
			//ObjectOutputStream oout= new ObjectOutputStream(new FileOutputStream("dir1/brad.obj"));
			
			oout.writeObject(b1);
			
			oout.flush();
			//因為上面使用了可自洞關必與法 所以這邊可以不用再關閉一次
			//oout.close();
			//如果程式正常執行 幫我印出ＯＫ
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e);
			}
		
		
	}

}
