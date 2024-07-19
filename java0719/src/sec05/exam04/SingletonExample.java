package sec05.exam04;

public class SingletonExample {

	public static void main(String[] args) {
		
//		Singleton s1 = new Singleton();
//		Singleton s1 = new Singleton(); 컴파일 에러
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if(s1 == s2) {
			System.out.println("같은 객체를 참조하고 있음");
		} else {
			System.out.println("다른 객체를 참조하고 있음");
		}

		
	}

}
