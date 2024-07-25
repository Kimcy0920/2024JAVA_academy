package java0725;

class Parent { // Parent 클래스
	int x;
	
	void method() {
		System.out.println(x);
	}
} 

public class Ex1 {

	public static void main(String[] args) {
		Parent parent = new Parent() { // 익명의 자식 객체 선언

			void method2() {
				System.out.println("오직 나만 사용");
			}
			
			@Override // 재정의
			void method() {
				x = 100;
				System.out.println("익명 자식 객체");
				super.method();
				method2();
			} 
			
		};
		
		parent.method();
//		parent.method2();
/* Parent parent = new Parent{};는 부모 타입의 '익명의' 자식 객체
 * 
*/

	}

}
