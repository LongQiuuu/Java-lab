package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBallGame extends JFrame{
	private int x, y;
	private Timer timer;
	
	public MyBallGame(){
		
		//將背板顏色加入面板
		setLayout(new BorderLayout());
		add(new MyPanel(), BorderLayout.CENTER);
		
		
		//初始化視窗大小
		setSize (640,480);
		setVisible (true);		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//派發球的任務
		timer = new Timer();
		//指派任務出去 時間到才做
		timer.schedule(new BallTask(), 1*1000, 60);
	}
	
	private class MyPanel extends JPanel {
		//背板顏色
		public MyPanel() {
			setBackground(Color.yellow);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//讀取球 並將球畫出來
			Graphics2D g2d =(Graphics2D)g;
			try {
				//讀球
				BufferedImage ball = ImageIO.read(new File("dir2/ball.png"));
				//將球畫在定點座標
				g2d.drawImage(ball, x, y, null);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		}		
	}
	
	//派發球的任務
	private class BallTask extends TimerTask {
		@Override
		public void run() {
			x += 100;
			y += 1;
			repaint(); //重新繪製
		}
	}
	public static void main(String[] args) {
		new MyBallGame();

	}

}

//球的任務