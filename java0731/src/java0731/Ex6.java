package java0731;

import java.util.Arrays;
import java.util.List;

public class Ex6 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동", "김박사", "엄복동", "김자반", "양금모");
		
		names.stream()
		.limit(3) // 3개만 가져오기
		.forEach(n->System.out.println(n));
		
//		names.stream()
//			.distinct()
//			.forEach(n->System.out.println(n));
//		System.out.println("-----");
//		
//		names.stream()
//			.filter(n->n.startsWith("엄"))
//			.forEach(n->System.out.println(n));
//		System.out.println("-----");
//		
//		names.stream()
//			.distinct()
//			.filter(n->n.startsWith("홍"))
//			.forEach(n->System.out.println(n));
		
		// .distinct() 중복없이, startsWith() 해당 문자열이 들어간
	}
}
