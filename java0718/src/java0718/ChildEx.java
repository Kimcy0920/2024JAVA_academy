//package java0718;
//
//public class ChildEx {
//
//	public static void main(String[] args) {
//		Parent parent = new Child(); // 다형성 / 자식으로 객체 생성
////		Parent parent = new Parent();
//		anyMethod(parent);
//		
////		Child child = (Child) parent;
////		child.method3();
//		if(parent instanceof Child) { // Child타입으로 인스턴스를 parent로 만들어도 되는지 확인
//			System.out.println("타입 변환 가능");
//			Child child = (Child) parent; // 강제 형변환
//		} else {
//			System.out.println("타입 변환 불가능");
//		} 
//		
//		public static void anyMethod(Parent parent) {
//			parent.method2();
//		}
//		
////		Other other = Parent; // 상속관계가 아니면 불가능
//		
////		parent.field2 = "data"; // 불가능
////		parent.method3();
//		
//	}
//
//}
