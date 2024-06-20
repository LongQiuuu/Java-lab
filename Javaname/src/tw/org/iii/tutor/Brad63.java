package tw.org.iii.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad63 {

	public static void main(String[] args) {
		//Timer timer =new Timer(true); 變成背景再跑 
		//Timer timer =new Timer(false);前景景再跑 
		//當前景跑完 背景也會被同步終止
		Timer timer =new Timer();
		Task1 t1 =new Task1();
		//新增停止任務 並讓他們互相認識
		StopTask s1 = new StopTask(timer);
		//指派任務出去 時間到才做  (t1, 0.1秒做一次,0.1秒再做一次)
		timer.schedule(t1, 100*10,10);
		
		//指派任務出去 時間到才做 三秒鐘之後幫我結束掉
		timer.schedule(s1, 5*1000);
		System.out.println("main");
	}

}

//新增一個類別 並讓他繼承週期任務
class Task1 extends TimerTask{
	private int i;
	//跟執行序寫的內容哺一樣 
	
	@Override
	public void run() {
		//這邊是寫時間到要做的事
		System.out.println(i++);
		
	}
	
}

//新增將timer停止的方法
//因為是外部類別 所以要先讓他們互相認識
class StopTask extends TimerTask{
	//互相認識
	private Timer timer;
	StopTask(Timer timer){
		this.timer = timer;
	}
	//時間到讓所有任務取消清除
	@Override
	public void run() {
		//時間到讓所有任務取消
		timer.cancel();
		//將任務清除
		timer.purge();
		
		timer = null;
	}
}

		

		

		