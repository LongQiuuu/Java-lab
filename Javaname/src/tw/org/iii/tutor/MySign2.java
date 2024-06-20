package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.apis.MyDrawer;

public class MySign2 extends JFrame{
	//宣告一個物件叫畫版
	public MyDrawer myDrawer;
	
	

	
	public MySign2() {
		//視窗標題
		super("簽名板");
		
		//建立一個物件 叫畫版
		myDrawer=new MyDrawer();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		
		//建立物件實體
		JPanel top = new JPanel(new FlowLayout());
		add(top, BorderLayout.NORTH);
		
		
		//下列這三行必須要在最後面
		//初始化視窗大小
		setSize (640,480);
		setVisible (true);		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	
			
	public static void main(String[] args) {
		new MySign2();

	}

}
