package java0725;

public class Ex4 {
	
	public static void method() throws ClassNotFoundException { // 예외 떠넘기기
//		Class.forName("qwerasdf"); // 예외처리가 필요
		Class.forName("qwerasdf");
	}

	public static void main(String[] args) {
		try { // 예외처리
			method();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
