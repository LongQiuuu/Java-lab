package tw.org.iii.tutor;
import java.io.File;
import java.io.IOException;


//已開發角度測試
public class Brad36 {

	public static void main(String[] args) {
		File f1 =new File("dir1");
		
		try {
			if (f1.createNewFile()) {
				
			}
			//拋出例外
		} catch (IOException e) {

		}
		

	}

}
