package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBallGame extends JFrame{
	//宣告四顆球做陣列
	private BufferedImage[] balls;

	//宣告視窗寬跟高
	private int viewW, viewH;
	
	public MyBallGame(){
		
		//將四顆球建立出來
		balls =new BufferedImage[4];
		//讀球出來
		try {
			balls[0] = ImageIO.read(new File("dir4/ball0.png"));
			balls[1] = ImageIO.read(new File("dir4/ball1.png"));
			balls[2] = ImageIO.read(new File("dir4/ball2.png"));
			balls[3] = ImageIO.read(new File("dir4/ball3.png"));
		//當拋出例外的時候	
		}catch(Exception e) {
			System.out.println(e); ;System.exit(0);
		}
		
		//將背板顏色加入面板
		setLayout(new BorderLayout());
		add(new MyPanel(), BorderLayout.CENTER);
		
		
		//初始化視窗大小
		setSize (640,480);
		setVisible (true);		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
	
	private class MyPanel extends JPanel {
		private Timer timer;
		//用資料結構建立多個任務承接球
		private LinkedList<BallTask> tasks;
		
		//背板
		public MyPanel() {
			//背板顏色
			setBackground(Color.yellow);
			//建構出多個任務來接球
			tasks = new LinkedList<>();
			//派發球的任務
			timer = new Timer();
			//指派任務出去 多久更新畫面
			timer.schedule(new RefreshView(), 0, 16);
			//監聽滑鼠類別
			addMouseListener(new MyMouseListener());
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//取的產生視窗牆壁的寬跟高
			viewW = getWidth(); viewH = getHeight();
			
			//讀取球 
			Graphics2D g2d =(Graphics2D)g;
			//將資料結構裡的球全部畫出來
			for (BallTask task : tasks) {
				g2d.drawImage(task.getImg(), task.getX(), task.getY(), null);
			}
			
		}
		//點擊滑鼠類別
		private class MyMouseListener extends MouseAdapter {
			//聽到之後做什麼事
			@Override
			public void mousePressed(MouseEvent e) {
				//點擊下去建立x ,y 並放入資料結構 task
				BallTask task = new BallTask(e.getX(), e.getY());
				//將多個任務加入
				tasks.add(task);
				//開始派發任務 
				timer.schedule(task, 500, 30);
			}
		}
		
		
		//更新畫面類別 
		private class RefreshView extends TimerTask {
			@Override
			public void run() {
				//重新繪製
				repaint();
			}
		}
	}
	
	
	//派發球的任務
	private class BallTask extends TimerTask {
		//球的座標 x , y 寬W 高h  dx x方向的移動距離   dy y方向的移動距離
		private int x, y, w, h, dx, dy;
		
		private BufferedImage img;
		
		//建構式球 物件初始化
		public BallTask (int touchX  , int touchY) {
			
			//隨幾出現四顆球
			int rand = (int)(Math.random()*4);	// 0 - 3
			
			//儲放陣列產生的球
			img = balls[rand];
			//抓球的寬高
			w = img.getWidth(); h = img.getHeight();
			//定義滑鼠點擊得到的x , y
			x = (int)(touchX - w / 2.0);
			y = (int)(touchY - h / 2.0);
			//設定球x方向的移動距離亂數 (因為我們設定 x ,y 一次座標動4 所以亂數產生我們取 -8～8
			dx = (int)(Math.random()*17) - 8;
			//設定球y方向的移動距離亂數
			dy = (int)(Math.random()*17) - 8;	
		}
		
		@Override
		public void run() {
			//判斷是不是有碰到牆壁
			//先判斷x 右邊牆壁左邊牆壁
			if (x + w >= viewW || x <= 0) {
				//撞到牆壁改變方向
				dx *= -1;
			}
			//再判斷y 上面牆壁下面牆壁
			if (y + h >= viewH || y <= 0) {
				//撞到牆壁改變方向
				dy *= -1;
			}
			
			//我每次球的座標加上距離 讓球動起來
			x += dx;
			y += dy;
			
		}
		// 因為 我上方定義private  所以需要產生給外部的使用方法
		public int getX() {return x;}
		public int getY() {return y;}
		public BufferedImage getImg() {return img;}
		
	}
	public static void main(String[] args) {
		new MyBallGame();

	}

}

//球的任務