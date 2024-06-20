package tw.org.iii.tutor;

public class brad09 {

	public static void main(String[] args) {
		int a=0;
		
		for (printBrad();a<10;printline()) {
			System.out.println(a++);
		}

	}


//建立這個方法
static void printBrad() {
	System.out.println("Brad");
}
//建立這個方法
static void printline() {
	System.out.println("-------");
}


}