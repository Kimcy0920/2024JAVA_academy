package sec01.exam05;

public class SmartPhoneEx {

	public static void main(String[] args) {
		SmartPhone myPhone = new SmartPhone("삼성", "안드로이드");
		
		String Obj = myPhone.toString(); // 재정의된 SmartPhone의 toString 호출
		System.out.println(Obj);
		
		System.out.println(myPhone); // 재정의된 toString() 호출 후 리턴값을 받아 출력

	}

}
