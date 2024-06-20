package tw.org.iii.apis;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;


//線
//類別設計從屬性出發
public class LineV2 {
	//用Map語法改寫
	private LinkedList<HashMap<String,Integer>> line;
	
	//線的顏色
	private Color color;
	//線的寬度
	private int width;
	//建構式帶入參數
	public LineV2(Color color, int width) {
		this.color = color;
		this.width = width;
		//line 在建構式裡初始化
		line = new LinkedList<>();
	}
		
		
	
	
	//建立方法
	//加入Point
	//用Map語法改寫
	public void addPoint(HashMap<String,Integer> point) {
		line.add(point);
	}
	
	//取得Point
	//用Map語法改寫
	public HashMap<String,Integer> getPoint(int index) {
		return line.get(index);
	}
	
	
	//取得顏色
	public Color getColor() {return color;}
	
	
	//取得寬度
	public int getWidth() {return width;}
	
	//取的內部元素
	public int size() {return line.size();}
}
