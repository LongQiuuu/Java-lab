package tw.org.iii.apis;

import java.awt.Color;
import java.util.LinkedList;

//線
//類別設計從屬性出發
public class Line {
	private LinkedList <Point>  line;
	
	//線的顏色
	private Color color;
	//線的寬度
	private int width;
	//建構式帶入參數
	public Line(Color color, int width) {
		this.color = color;
		this.width = width;
		//line 在建構式裡初始化
		line = new LinkedList<>();
	}
		
		
	
	
	//建立方法
	//加入Point
	public void addPoint(Point point) {
		line.add(point);
	}
	
	//取得Point
	public Point getPoint(int index) {
		return line.get(index);
	}
	
	
	//取得顏色
	public Color getColor() {return color;}
	
	
	//取得寬度
	public int getWidth() {return width;}
	
	//取的內部元素
	public int size() {return line.size();}
}
