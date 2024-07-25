package java0725;

class MyClass {
	void method() throws Exception { // throws
		int x = 100;
		if (x > 90) {
			throw new Exception("음..음흠.음...흠!음."); // 예외 발생
			// throw new: (생성자)
		}
		
	}
}

public class MyExceptionEx1 {

	public static void main(String[] args) {
		MyClass mc = new MyClass();
		try {
			mc.method();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
