package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.org.iii.apis.MyClock;
import tw.org.iii.apis.MyDrawerV2;

public class MySignV2 extends JFrame{
	//宣告一個物件叫畫版
	public MyDrawerV2 myDrawerV2;
	//宣告按鈕
	private JButton clear, undo, redo, color, width, saveJPEG, saveLines, loadLines;
	//宣告時間
	private MyClock myClock;
	

	
	public MySignV2() {
		//視窗標題
		super("簽名板");
		
		//建立一個物件 叫畫版
		myDrawerV2=new MyDrawerV2();
		setLayout(new BorderLayout());
		add(myDrawerV2, BorderLayout.CENTER);
		
		//建立三顆按鈕
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		saveJPEG = new JButton("Save JPEG");
		saveLines = new JButton("Save Lines");
		loadLines = new JButton("Load Lines");
		//建立時間物件實體
		myClock = new MyClock();
		//建立最上層小隔間物件實體
		JPanel top = new JPanel(new FlowLayout());
		//將按鈕加入最上層小隔間
		top.add(clear); top.add(undo); top.add(redo); top.add(color);
		top.add(saveJPEG); top.add(saveLines); top.add(loadLines);
		top.add(myClock);
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
				myDrawerV2.clear();
			}
		});
		
	
		//undo 回覆
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawerV2.undo();
			}
		});
		
		//redo 回復上一個操作
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawerV2.redo();
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
		
		//儲存圖片
		saveJPEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//因為我在saveJPEG()錯誤拋出 所以要變成在這邊處理 來抓取錯誤
				try {
					//呼叫
					myDrawerV2.saveJPEG();
					//當成功儲存跳出訊息
					JOptionPane.showMessageDialog(null, "Save JPEG success");
				} catch (IOException e1) {
					//當發生例外的時候跳出儲存失敗訊息
					JOptionPane.showMessageDialog(null, "Save JPEG failure");
				}
			}
		});
		// 存檔功能 (由外部決定他要存取哪個檔案)
		saveLines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//呼叫下列方法
				saveLines();
			}
		});
		//打開存檔
		loadLines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//呼叫下方方法
				loadLines();
			}
		});
		
		
	}

	//存檔方法
	private void saveLines() {
		JFileChooser jfc = new JFileChooser();
		if ( jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
			File selectedFile = jfc.getSelectedFile();
			try {
				myDrawerV2.saveLine(selectedFile);
				JOptionPane.showMessageDialog(null, "Save Success");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Save Failure");
			}
		}
	}
	
	//打開存檔方法
	private void loadLines() {
		JFileChooser jfc = new JFileChooser();
		if ( jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ) {
			File selectedFile = jfc.getSelectedFile();
			try {
				myDrawerV2.loadLine(selectedFile);
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Load Failure");
			}
		}		
	}
	//更換顏色方法
	private void changeColor() {
		//選顏色
		Color newColor = JColorChooser.showDialog(null, "Change Line Color", myDrawerV2.getColor());
		//判斷只要不是沒選顏色  就是有選顏色並改變他顏色
		if (newColor != null) {
			myDrawerV2.changeColor(newColor);
		}
	}
	
		
	
	
		
	public static void main(String[] args) {
		new MySignV2();

	}

}
