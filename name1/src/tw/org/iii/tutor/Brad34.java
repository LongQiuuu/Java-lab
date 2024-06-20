package tw.org.iii.tutor;

import java.io.File;

public class Brad34 {
	public static void main(String[] args) {
	File fi =new File("dir1");
	
	//沒有dir3 但是物件仍是可以正常建立
	//File f2 =new File("dir3");
	
	//從跟寫起就是絕對路徑表示法
//	File f2 =new File("/Users/long/eclipse-workspace/name/dir1");
//	System.out.println(f1.equals(f2));
//	File f3 =new File("路徑");
//	File f4 =new File("路徑");
//	File f5 =new File("dir3");
	
	//判斷ｆ５有沒有這個資料夾
//	if(!f5.exists()) {
		//如果沒有就幫我建立這個資料夾
//		f5.mkdir();
//	}
//	判斷
//	File f6 =new File("dir1/dir2/dir3");
//	if(!f5.exists()) {
		//如果沒有就幫我建立這個資料夾
		//mkdirs 當你父目錄不再仍可以建立
//		f5.mkdirs();
//	}
	//資料夾底下的文字檔
	File f7 =new File("dir1/file.txt");  //原本就存在
	File f8 =new File("dir1/file1.txt"); //不存在
	
	//將資料夾改改名 將file 改名為file1
	f7.renameTo(f8);
	
	
	File f77 =new File("dir1/file1.txt");  //存在
	File f88 =new File("dir2/file3.txt"); //不存在
	//移動文件檔 到資料夾dir2     renameTo==剪下貼上改名字
	f77.renameTo(f88);
	
	}
}
