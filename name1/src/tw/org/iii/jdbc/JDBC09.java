package tw.org.iii.jdbc;

import tw.org.iii.apis.BCrypt;

//會員登入加解密
public class JDBC09 {

	public static void main(String[] args) {
		//設定密碼
		String passwd="123456";
		//加鹽動作
		String hwpasswd= BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hwpasswd);
		
		String input="123456";
		
		if (BCrypt.checkpw(input,hwpasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
	}

}
