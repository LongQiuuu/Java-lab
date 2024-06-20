package tw.org.iii.apis;
//簽名板座標位置 滑鼠
public class Point {
	private int x,y;
	
	//觸發啟動建構式
	public Point(int x , int y){
		this.x=x; this.y=y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
}
