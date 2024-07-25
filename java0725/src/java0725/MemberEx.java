package java0725;

class Member2 {
	String id;
	
	Member2(String id) {
		this.id = id;
	}
}

public class MemberEx {

	public static void main(String[] args) {
		String str1 = new String("blue");
		String str2 = new String("blue");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());	
		if (str1.equals(str2)) {
			System.out.println("str1과 str2는 같다");
		} else {
			System.out.println("str1과 str2는 다르다");
		}
		
//		if (str1 == str2) {
//			System.out.println("str1과 str2는 같다");
//		} else {
//			System.out.println("str1과 str2는 다르다");
//		}
		
		System.out.println("----------------");
		
		Member mb1 = new Member("blue");
		Member2 mb2 = new Member2("blue");
		if (mb1.equals(mb2)) {
			System.out.println("mb1과 mb2는 같다");
		} else {
			System.out.println("mb1과 mb2는 다르다");
		}
	}

}

/*
 * String은 API에 속해있고, Member는 직접 만든 것
 * String는 API에 equals로 비교할 수 있게 처리되어 있음.
*/