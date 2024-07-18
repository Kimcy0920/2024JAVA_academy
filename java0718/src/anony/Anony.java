package anony;

public class Anony {
	
	void method() {
		Person person = new Person() { // 클래스 익명 객체

			@Override
			void wake() {
				// TODO Auto-generated method stub
				super.wake();
			}
			
		};
		
		Person2 person2 = new Person2() { // 추상 클래스 익명 객체
		};
		
		Person3 person3 = new Person3() { // 인터페이스 익명 객체
			
			@Override
			public void wake() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
