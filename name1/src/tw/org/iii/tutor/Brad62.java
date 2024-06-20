package tw.org.iii.tutor;


//多執行序
public class Brad62 {

	public static void main(String[] args) {
		MyThread mt1 =new MyThread("A");
		MyThread mt2 =new MyThread("B");
	
		//用生命的表現來看待這次的執行 就會讓他們同時執行
		//但任何一個執行序 生命只能執行一次
		mt1.start();
		
		mt2.start();
		//mt2.start();我同時呼叫mt2兩次就會報錯 因為生命週期只能一次
		System.out.println("main");
		
		//我建立了一格介面
		MyRunnable mr1=new MyRunnable("c");
		//我在用Thread來建構他 讓它就可以同時擁有Thread多執行續了  MyRunnable從這行開始才是多執行續
		Thread mt3 =new Thread (mr1);
		mt3.start();
		
		
		//當場實作執行續且當場執行 
		new Thread () {
			public void run() {
			}
		}.start();

	}
}
//要多執行續 要繼承extends Thread
class MyThread extends Thread{
	private String name;
	public MyThread (String name) {
		this.name=name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.printf("%s:%d\n",name ,i);
			//執行完讓程式睡一下
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			
			
			}
		}
	}
}

//繼承只能繼承一個父類別 我可以用介面的方式來規避這個規則 在這邊的MyRunnable 完全不是執行序 
class MyRunnable implements Runnable{
	private String name;
	public MyRunnable (String name) {
		this.name=name;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.printf("%s:%d\n",name ,i);
			//執行完讓程式睡一下
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			
			
			}
		}
	}
}
