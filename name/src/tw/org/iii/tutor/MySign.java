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

public class MySign extends JFrame{
	//宣告一個物件叫畫版
	public MyDrawer myDrawer;
	private JButton clear, undo, redo, color, width;
	

	
	public MySign() {
		//視窗標題
		super("簽名板");
		
		//建立一個物件 叫畫版
		myDrawer=new MyDrawer();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		//建立三顆按鈕
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		//建立物件實體
		JPanel top = new JPanel(new FlowLayout());
		//將按鈕加入
		top.add(clear); top.add(undo); top.add(redo); top.add(color);
		add(top, BorderLayout.NORTH);
		
		
		//下列這三行必須要在最後面
		//初始化視窗大小
		setSize (640,480);
		setVisible (true);		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//呼叫按鈕方法
		addEnents();
		
	}
	
	
	//按鈕方法
	private void addEnents() {
	
		//清除按鈕事件 當場實作 
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//呼叫
				myDrawer.clear();
			}
		});
		
	
		//undo 回覆
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		
		//redo 回復上一個操作
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		
		//更換顏色
		color.addActionListener(new ActionListener() {
			//呼叫更換顏色方法  方便程式簡潔 將方法拉出去寫
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		
	}
	
	
	//更換顏色方法
	private void changeColor() {
		//選顏色
		Color newColor = JColorChooser.showDialog(null, "Change Line Color", myDrawer.getColor());
		//判斷只要不是沒選顏色  就是有選顏色並改變他顏色
		if (newColor != null) {
			myDrawer.changeColor(newColor);
		}
	}
	
		
	
	
		
	public static void main(String[] args) {
		new MySign();

	}

}
