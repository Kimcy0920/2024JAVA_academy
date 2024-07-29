package java0729;

public class Ex3 {
	public static void main(String[] args) {
		int x = 100; // Primetive data type
		Integer y; // Wrapper type
		Integer z = 400;
		y = 100;
		
		x = Integer.parseInt("400"); // Wrapper
		x = Integer.valueOf("400");
		y = new Integer("400"); // 사용X
		y = Integer.valueOf("400");
		
		if (y == z) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		if (y.equals(z)) { // 문자열뿐만 아니라 클래스타입일 경우에도 equals 사용해 비교
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		
		String str2 = String.valueOf(123); // 문자열 변환, 123+"" 비추
		System.out.println(str2);
		String str = "이것은 자바 대치 예제입니다.";
//		String str2 = new String("이것은 자바 대치 예제입니다."); 동일함 new String 생략가능
		String newStr = str.replace("예제", "코드");
		str = str.replace("예제", "코드");
		System.out.println(str);
//		System.out.println(str2);
		System.out.println(newStr);
		
		if (str == newStr) {
			System.out.println("같은 저장소");
		} else {
			System.out.println("다른 저장소");
		}
		
		if (str.equals(newStr)) {
			System.out.println("같은 저장소");
		} else {
			System.out.println("다른 저장소");
		}
		
	}
}
