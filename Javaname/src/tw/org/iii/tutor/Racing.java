package tw.org.iii.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//利用多執行續來做一個賽車遊戲
public class Racing  extends JFrame{
	
	//宣告按鈕
	private JButton go;
	//宣告跑到陣列
	private JLabel[] lanes;
	//宣告汽車的類別
	private Car[] cars;
	//宣告名次
	private int rank;
	
	public Racing() {
		super ("Racing");
		
		
		setLayout(new GridLayout(9,1));
		//建立按鈕
		go = new JButton("Go!"); add(go);
		//建立汽車物件實體
		cars = new Car[8];
		//建立跑道
		lanes = new JLabel[8];
		
		for (int i=0; i<lanes.length; i++) {
			//一個跑道一個跑道用迴圈建立出來
			lanes[i] = new JLabel(String.format("%d.", (i+1)));
			//將跑道加入
			add(lanes[i]);
		}
		
		//監聽到go這個按鈕被觸發當場實作 go方法
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		
		//下列這三行必須要在最後面
		//初始化視窗大小
		setSize (800,480);
		setVisible (true);		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//按下go這個按鈕產生的方法
	private void go() {
		//當go這個扭按下讓他變得不能動
		go.setEnabled(false);
		//將跑道初始化
		initGame();
		//將八台車用迴圈初始化建立出來
		for(int i=0; i<cars.length; i++) cars[i] = new Car(i);
		for (int i = 0; i<cars.length; i++) {
			//用多執行序 start 生命執行序
			cars[i].start();
		}
	}
	
	//跑到初始化 （清空跑道）
	private void initGame() {
		for (int i=0; i<lanes.length; i++) {
			lanes[i].setText(String.format("%d.", (i+1)));
		}
		rank = 0;
	}
	

	//內部類別 因為我有可能存取外部類別的屬性跟方法
	//車子並將他繼承執行序
	class Car extends Thread {
		private int lane;
		//建構式 第幾跑道 
		//透過建構式決定哪台車跑哪一個跑道
		Car(int lane){
			this.lane = lane;
		}
		@Override
		public void run() {
			//for每台車都做一樣的事
			for (int i=0; i<100; i++) {
				
				//新增排名判斷
				if(i==99) {
					//lanes[lane] 哪台車在哪個跑道  setText.(我把現有跑道 ＋上“>”符號 +達到加上名次) 顯示一到最後一名
					//lanes[lane].setText(lanes[lane].getText() + ">" + ++rank);
					
					//當有人第一名停止其他程式
					lanes[lane].setText(lanes[lane].getText() + "> ＷＩＮ" );
					stopGame();
				}else {
					//lanes[lane] 哪台車在哪個跑道  setText.(我把現有跑道 ＋上“>”符號)
					lanes[lane].setText(lanes[lane].getText() + ">");
				}

				//稍微讓程式睡一下下
				try {
					//為了讓不同的車子可以有不同的執行序 我讓他休息 並讓他加上亂數 這樣每圈迴圈再跑的時候就有不同的速度
					Thread.sleep(10+(int)(Math.random()*200));
				} catch (InterruptedException e) {
					//此時我在跳出迴圈
					break;
				}
			}
		}
	}
	public  void stopGame(){
		for(int i=0; i<cars.length;i++) {
			//叫他們每一台車 去呼叫所在執行序的插斷
			cars[i].interrupt(); 
			//當程式收到這個插斷的時候就會觸發catch (InterruptedException e)
		}	
		//將ｇｏ的按鈕變成可以按
		go.setEnabled(true);
	}	
		

	public static void main(String[] args) {
		new Racing();

	}

}
