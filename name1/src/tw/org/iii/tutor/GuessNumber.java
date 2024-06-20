package tw.org.iii.tutor;
//外接視窗
import java.awt.BorderLayout;
//外接監聽
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//跳出訊息 外接
import javax.swing.JOptionPane;
//字型外接
import java.awt.Font;
//外接按鈕
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//外接視窗
import javax.swing.JFrame;
//外接隔間
import javax.swing.JPanel;

//若只有一個按鈕需要監聽 可以直接新增 implenents ActionListener
public class GuessNumber extends JFrame implements ActionListener{
	
	//擁有這三顆按鈕宣告
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	
	//產生數字宣告
	private String answer;
	
	//計數器
	private int counter;
	
	//猜幾碼
	private int d = 3;
	
	public GuessNumber() {
		
		
		//視窗標題
		super("猜數字遊戲");
		
		//按鈕初始化
		guess = new JButton("猜");
		input = new JTextField();
		log   = new JTextArea();
		
				
		//不固定按鈕位置BorderLayout
		setLayout(new BorderLayout());
		//隔間 設定區域變數 因為我只有這個地方會用到它
		JPanel top = new JPanel(new BorderLayout());
		//在隔間裡面 新增guess並把他丟東邊
		top.add(guess, BorderLayout.EAST);
		//在隔間裡面 新增inpus放中間 
		top.add(input, BorderLayout.CENTER);
		//最外面ＴＯＰ放北邊
		add(top, BorderLayout.NORTH);
		//log 放中間
		add(log, BorderLayout.CENTER);
		
		//設定字型
		//初始化
		//input.setFont(new Font(null, Font.BOLD, 36));
		//設定lod 字型
		log.setFont(new Font(null, Font.BOLD + Font.ITALIC, 36));
		
		//設定按鈕監聽
		initEvent();
		//初始化的時候順便開新局
		initGame();
		//下列這三行必須要在最後面
		//初始化視窗大小
		setSize (640,480);
		setVisible (true);		
		//視窗關閉就離開
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//開新局//產生數字
	private void initGame() {
		//計數器每局歸零
		counter = 0;
		//設定謎底數字
		answer= createAnswer(d);
		System.out.println(answer);
		
		//開新局清空
		log.setText("");
	}
	
	//為按鈕賦予一個動作監測者 
	private void initEvent() {
		MyListener myListener = new MyListener(this);
		//第一種方法使用API協助監聽
		//但這種方法需要使用 MyListener 需在下方建立類別
		guess.addActionListener(myListener);
		//第二種方法使用本身自己監聽GuessNumber 
		guess.addActionListener(this);
		//第三種方法當場實作 （方便維護）
		guess.addActionListener(new ActionListener() {
			//第三種方法監聽產生
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK3");
				//呼叫按鈕
				guess();
			}
		});
		
		//第四種方法產生監聽
		guess.addActionListener(new ButtonListener());
	}
	
	
	//按下猜這個按鈕要做的事
	private void guess() {
		//計數器累計
		counter++;
		//取得文字
		String strInput = input.getText();
		//幾Ａ幾Ｂ結果回傳接收
		String result = checkAB(strInput);
		//將幾Ａ幾Ｂ結果放到log上面
		log.append(result + "\n");
		
		//清除框框輸入過的字
		input.setText("");
		
		//判斷只能猜十次結束遊戲
		//字串比對要用equals
		if (result.equals(String.format("%dA0B",d))) {
			JOptionPane.showMessageDialog(null, "恭喜老爺");
			initGame();
		}else if (counter == 3) {
			JOptionPane.showMessageDialog(null, "魯蛇, 答案是:" + answer);
			initGame();
		}
		
	}
	
	//判斷數字
	private String checkAB(String strGuess) {
		int a, b ; a=b=0;
		//開始判斷
		for (int i=0; i<answer.length(); i++) {
			if (strGuess.charAt(i) == answer.charAt(i)) {
				a++;
			}else if (answer.indexOf(strGuess.charAt(i)) != -1) {
				b++;
			}
		}
		
		return String.format("%dA%db" ,a,b);
	}
	
	//產生謎底數字
	private String createAnswer(int d){
		int num=10;
		int []poker=new int[num];
		//取得10張牌
		for(int i = 0 ; i < num;i++) {
			poker[i]=i;}

		//從9 開始倒算  遞減模式
		for(int i =num-1;i>0;i--) {
			
			int rand = (int)(Math.random()*(i+1)); //原本i被減一  所以要加回來
			//開始做交換
			int temp =poker[rand];
			poker[rand]=poker[i];
			poker[i]=temp;
		}
		StringBuffer sb= new StringBuffer();
		
		for(int i=0;i<d;i++) {
			sb.append(poker[i]);
		}
		return sb.toString();
	}

	
	
	
	public static void main(String[] args) {
		new GuessNumber();

	}
	
	//第二種方法監聽 觸發產生方法
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK2");
		
	}
	
	//第四種方法監聽  類別中的類別曹撞類別
	//原本存取修飾字與物件成員相同 若是我不想讓人使用可修改
	class ButtonListener implements ActionListener{
		////第四種方法監聽 觸發產生方法
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("OK4");
		
		}
	}

}

//這邊定意一個動作監聽者類別
class MyListener implements ActionListener {
	//讓MyListener 認識guessNumber
	//建構式
	private GuessNumber guessNumber;
	
	public MyListener(GuessNumber guessNumber) {
		this.guessNumber = guessNumber;
	}
	
	//第一種方法監聽 觸發產生方法
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK1");
	
	}
}