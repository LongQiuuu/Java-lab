package tw.org.iii.apis;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	//我擁有一個LinkedList資料結構 並取名line
	//肚子只裝Point類別
	//private LinkedList <Point> line;我這邊只宣告一條線而已
	//如果需要很多條線 可以在包private LinkedList< LinkedList <Point>> lines;
	private LinkedList<Line> lines, rbin;
	
	//擁有顏色
	private Color defColor;
	
	//擁有寬度
	private int width;
	
	
	//建構式
	public  MyDrawer (){
		//建立一個點的物件實體實體
		lines = new LinkedList<>();
		//建立回收桶的物件實體
		rbin = new LinkedList<>();
		
		//建立顏色物件實體
		defColor = Color.blue;
		
		//建立寬度物件實體
		width = 4;
		
		//設定背景顏色
		setBackground(Color.yellow);
		//建立MyMouseListener物件實體
		MyMouseListener listener = new MyMouseListener();
		//開始監聽
		//點下去監聽
		addMouseListener(listener);
		//滑行監聽
		addMouseMotionListener(listener);
	}
	
	
	
	//生命週期 時間到就會觸發
	@Override
	protected void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		System.out.println("OK");
		
		//知道哪個類別再來強制轉型
		Graphics2D g2d = (Graphics2D)g;
		//在開始畫線的時候先 設定線的顏色
		//g2d.setColor(Color.blue);
		//設定寬度 因為有強制轉型所以可以使用這個功能
		g2d.setStroke(new BasicStroke(width));		
		//開始畫線
		//g2d.drawLine(0, 0, 200, 400); 定義原本的線得位置
		
		//用for 迴圈 尋訪所有元素（很多條線）
		for (Line line : lines)  {
			//將顏色抓出來
			g2d.setColor(line.getColor());
			
			//任何時候找我的點 並將線段畫出來（一條線)
			//line.size 裡面有幾個元素
			for (int i=1; i<line.size(); i++) {
				//開始畫線
				Point p0 = line.getPoint(i-1);
				Point p1 = line.getPoint(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}
		
		
		
		
		
		
		
		//用instanceof 來判斷g裡面是哪個類別  判斷出g的類別是Graphics2D
		if (g instanceof Graphics2D) {
			System.out.println("OK2");
		}else if(g instanceof DebugGraphics) {
			System.out.println("OK3");
		}
		
	}
	
	//clear按鈕清空功能
	public void clear() {
		lines.clear();
		repaint();
	}
			
			
	//undo按鈕回復功能
	public void undo() {
		//回復最後一條線removeLast
		//判斷資源回收桶裡面有沒有線 有線就執行
		if (lines.size() > 0) {
			//垃圾桶 rbin取出加入
			rbin.add( lines.removeLast());
			repaint();
			}		
	}
			
	//rudo 重回上一個步驟
	public void redo() {
		if (rbin.size() > 0) {
			lines.add(rbin.removeLast());
			repaint();
			}
	}
	
	//更換顏色
	public void changeColor(Color newColor) {
		//將ＤＥＦ 顏色 改成新的顏色
		defColor = newColor;
	}
		
	
	//取得現在顏色
	public Color getColor() {
		return defColor;
	}
		
	//建立巢狀類別
	//MouseAdapter 使用這個ＡＰＩ   可以我只要對我想要當方法繼承就好
	private class MyMouseListener extends MouseAdapter{
		//滑鼠點擊
		@Override
		public void mousePressed(MouseEvent e) {
			//產生了一個點 並收集
			Point point = new Point(e.getX(), e.getY());
			//宣告新的線
			Line line = new Line(defColor, 4);
			//將這個點加入 line
			line.addPoint(point);;
			//原本是區域變數 所以要把線加入進來
			lines.add(line);
			//當他要畫新線 垃圾桶清除
			rbin.clear();
		}
		
		//滑鼠Drag
		public void mouseDragged(MouseEvent e) {
			//產生了一個點 並收集
			Point point = new Point(e.getX(), e.getY());
			//從 lines 取得最後一條 並將這個點加入 line
			lines.getLast().addPoint(point);;
		    //幫我重新產生 物件  重新繪製
			repaint();
		}
	}
	
}

