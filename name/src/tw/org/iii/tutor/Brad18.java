package tw.org.iii.tutor;

//外接 ＪＦrame API
import javax.swing.JFrame;
//外接按鈕 API
import javax.swing.JButton;

//外接添加按鈕API
import java.awt.FlowLayout;

//繼承 ＪＦrame
public class Brad18 extends JFrame{
	//我想要有按鈕
	private JButton b1,b2,b3 ;
	
	
	//不想沿用JFrame的建構式
	//定義自己的建構式
	public Brad18() {
		super ("我的視窗");
		System.out.println("Brad18()");
		
		//設定按鈕初始化
		b1 = new JButton("b1");
		b2 = new JButton("b2");
		b3 = new JButton("b3");
		
		//將按鈕放入視窗裡
		setLayout(new FlowLayout());
		add(b1);add(b2);add(b3);
		
		
		//限定視窗大小
		setSize (640,480);
		setVisible (true);
		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		//建立一個實體
		new Brad18();
		
	}

}
