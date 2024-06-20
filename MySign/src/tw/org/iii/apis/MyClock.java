package tw.org.iii.apis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

//製作一個時間類別 並放到 MySignV2 實現
public class MyClock  extends JLabel{
	private Timer timer;
	public MyClock(){
		//建構Timer
		timer =new Timer();
		//指派任務 執行ClockTask()方法
		timer.schedule(new ClockTask(), 100*10,10);
		
	}
	//撰寫時鐘任務 內部類別
	private class ClockTask extends TimerTask{

		@Override
		public void run() {
			//建立現在時間物件實體
			Date now = new Date();
			//建立時間格式實體
			SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
			//將now的時間轉成 sdf取得的格式
			setText(sdf.format(now));
			
		}
		
	}
	
}
