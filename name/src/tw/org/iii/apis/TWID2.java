package tw.org.iii.apis;

public class TWID2 {
	//物件屬性 
	private String id;
	//類別屬性
	//(這邊Ａ-Z不是照順序 因為身分證規則表將這些數字更換）
	private static String letters="ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	//這邊要限制只能這邊使用private
	private TWID2(String id) {
		this.id=id;
	}
	
	//設立建構式
	//讓建構式互相產生關臉使用this
	public TWID2() {
		//與男生女生 產生關聯
		//從零開始幾個 不是零就是一 加上判斷是 == 0 true  若不是就是false
		this((int)(Math.random()*2) == 0);
	}
	
	//男生女生
	//第一段產生布林值 就帶入這邊做運算
	public TWID2(boolean isMale) {
		this(isMale, (int)(Math.random()*26));
	}
	//地區
	public TWID2(int area) {
		this((int)(Math.random()*2) == 0, area);
	}
	
	//地區加上男生女生
	//並創立身分證產生器
	public TWID2(boolean isMale,int area) {//area =0-25
		//為了不讓字串相加 使用StringBuffer ＡＰＩ
		StringBuffer sb = new StringBuffer();
		sb.append(letters.substring(area,area+1))  //第一碼
			.append(isMale ? "1" :"2") //第二碼
			.append((int)(Math.random()*10))//第三碼
			.append((int)(Math.random()*10))//第四碼
			.append((int)(Math.random()*10))//第五碼
			.append((int)(Math.random()*10))//第六碼
			.append((int)(Math.random()*10))//第七碼
			.append((int)(Math.random()*10))//第八碼
			.append((int)(Math.random()*10));//第九碼
		
			//最後第十碼是驗證碼 
		    //使用toString 將變數改成字串
			String temp = sb.toString();
				for (int i=0; i<10; i++) {
					if (checkTWID(temp + i)) {
						id = sb.append(i).toString();
						break;
					}
				}	
		
	}
	
	//配合檢驗方法
	public static TWID2 createTWId(String id) {
		TWID2 temp = null;
			if (checkTWID(id)) {
				temp = new TWID2(id);
			}
			return temp;
	}
	
	//指定字串建構式
	@Override
	public String toString() {
		return String.format("ID = %s", id);
	}
	
	
	//static 與物件無關 只需要傳參數 就可使用 （類別可做為分類使用）
	public static boolean checkTWID (String id) {
		//1. 身分證長度為10碼
		//2. 第一碼 =>A-Z
		//3. 第二碼 =>1/2
		//4. 第三到十碼 =>0-9
		
		boolean isRight =false;
		
		//matches 判斷ID是不是正規表示法
		//if (id.matches("[第一碼][第二碼][第三碼]{第三碼判斷出現八次}"))
		if (id.matches("[A-Z][12][0-9]{8}")) {
			//開始做身分證驗證 (這邊Ａ-Z不是照順序 因為身分證規則表將這些數字更換）
			
			char c1= id.charAt(0);
			//取轉換數值 要看身分證規則表
			int a12 =letters.indexOf(c1)+10;
			//取a1 a2的值 要看身分證規則表
			int a1 = a12/10;
			int a2 = a12%10;
			//substring 從字符串取擷取中間子字串 無法取到最後一個字串
			//因為這方法回傳的是字串 所以使用Integer.parseInt轉回
			int n1 = Integer.parseInt(id.substring(1,2));
			int n2 = Integer.parseInt(id.substring(2,3));
			int n3 = Integer.parseInt(id.substring(3,4));
			int n4 = Integer.parseInt(id.substring(4,5));
			int n5 = Integer.parseInt(id.substring(5,6));
			int n6 = Integer.parseInt(id.substring(6,7));
			int n7 = Integer.parseInt(id.substring(7,8));
			int n8 = Integer.parseInt(id.substring(8,9));
			int n9 = Integer.parseInt(id.substring(9,10));
			int n = a1*1 + a2*9 + n1*8 + n2 *7 + n3*6 + n4*5 + n5*4 + n6*3 + 
					n7*2 + n8*1 + n9*1;
			//最後判斷服不符合規則 要看身分證規則表
			isRight = n % 10 == 0;
			
			
		}
		return isRight;
		
	}
}
