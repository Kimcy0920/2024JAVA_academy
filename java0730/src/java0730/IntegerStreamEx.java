package java0730;

import java.util.stream.IntStream;

public class IntegerStreamEx {

	public static void main(String[] args) {
		int count = 10;
		IntStream ii = IntStream.range(1, 5); // 1부터 5가 되기 전까지
		IntStream ii2 = IntStream.rangeClosed(1, 5); // 1부터 5까지
// [1]	ii.forEach(System.out::println); // 메소드 참조
		
// [2]	ii.forEach(a->{ // 같은 코드
//			System.out.println(a);
//		});
		
//		ii2.forEach(a->{ // 같은 코드
//			System.out.println(a);
//		});
		
		int sum = IntStream.rangeClosed(1, count).sum();
		System.out.println(sum);
		
	}
}
