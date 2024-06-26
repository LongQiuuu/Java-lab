package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tw.org.iii.apis.Scooter;

public class Brad49 {

	public static void main(String[] args) {
		Student s1 = new Student("Brad", 45, 32, 56);
		System.out.println(s1.total());
		System.out.println(s1.avg());
		
		//第二個學生
		Student s2 = new Student("Eric", 90, 97, 86);
		System.out.println(s2.total());
		System.out.println(s2.avg());
		System.out.println("---");

		//序列化
		try (ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream("dir1/s1.obj"))){
			//第一個學生序列化
			oout.writeObject(s1);
			//第二個學生序列化
			oout.writeObject(s2);
		}catch (Exception e) {
			System.out.println(e);
			}
		
		//解序列化 try後面加（）自動關閉語法
		try(ObjectInputStream oin = new ObjectInputStream(
				new FileInputStream("dir1/s1.obj"))){
			//第一個學生解序列化
			Student s3 =  (Student)oin.readObject();
			System.out.println(s3.total());
			System.out.println(s3.avg());
			//第二個學生解序列化
			Student s4 =  (Student)oin.readObject();
			System.out.println(s4.total());
			System.out.println(s4.avg());
		}catch (Exception e) {
			System.out.println(e);
			}
		
		
	}

}

class Student implements Serializable{
	private int ch,eng,math;
	private String name;
	private Scooter scooter;
	
	//建構式
	public Student(String name,int ch , int eng ,int math) {
		this.name=name;
		this. ch= ch;
		this. eng= eng;
		this.math=math;
		
		//建構摩托車物件實體
		scooter= new Scooter(name);
	}	
	public int total() {return ch+eng+math;}
	public double avg() {return total()/3.0;}
}
