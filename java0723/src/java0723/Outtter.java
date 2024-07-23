package java0723;

// 로컬: 메서드 안

public class Outtter {
	
	public void method1(int arg) { // 메서드
		int localVar = 1;
		
//		arg = 100;
//		localVar = 100;
		
/* p.436 참고
 * arg와 localVar가 Inner 클래스에서 사용됨
 * Inner 클래스가 스레드로 돌아가는 경우 arg와 localVar가 있어야 하는데
 * method1이 종료되거나 arg와 localVar 값이 바뀌어서 영향을 주면
 * 안되기때문에 final로 선언해야함
*/
		
		class Inner { // 메서드 안에 클래스 -> 로컬 클래스
			public void method() {
				int result = arg + localVar;
				System.out.println(result);
			}
		}
		Inner inner = new Inner();
		inner.method();
	}
}
