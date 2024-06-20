package tw.org.iii.tutor;

import java.io.File;

public class Brad33 {

	public static void main(String[] args) {
		//印出路徑的分隔
		System.out.println(File.pathSeparator);
		//印出路徑
		System.out.println(File.separator);
		
		//window 範例
		//File file=new File("c:\brad\test1");
		//因為原本會卡到跳脫字元 所以要改寫
		File file=new File("c:/brad/test1");
		//這個路徑資料夾是否存在
		System.out.println(file.exists());
		System.out.println("-----------");
		// "."目前當前路徑
		File f1=new File(".");
		//印出
		System.out.println(f1.getAbsolutePath());
		//這個f2 等於這個資料夾路徑
		File f2=new File("./dir2");
		//這個路徑資料夾是否存在
		System.out.println(f2.exists());
		
		
	}

}
