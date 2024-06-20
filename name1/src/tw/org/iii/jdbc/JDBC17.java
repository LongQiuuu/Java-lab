package tw.org.iii.jdbc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.org.iii.apis.MyTable;

//視窗物件
//Jtable 完表格
//顯示美食資料庫的資料  （介面）
public class JDBC17 extends JFrame {
	//擁有 MyTable類別
	private MyTable myTable;
	
	//擁有刪除按鈕
	private JButton del;
	
	
	public JDBC17() {
		//建造刪除按鈕
		setLayout(new BorderLayout());
		
		del = new JButton("Del");
		JPanel top = new JPanel(new FlowLayout());
		top.add(del);
		add(top, BorderLayout.NORTH);
		//按鈕監聽 並當場實作
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//呼叫刪除功能
				myTable.delRow();
			}
		});
		
		
		//建構出mytable 物件實體
		myTable = new MyTable();
		JScrollPane jsp = new JScrollPane(myTable);
		add(jsp, BorderLayout.CENTER);
	
		
		
		//下列這三行必須要在最後面
		//初始化視窗大小
		setSize (640,480);
		setVisible (true);		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new JDBC17();

	}

}
