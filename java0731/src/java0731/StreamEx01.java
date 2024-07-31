package java0731;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class StreamEx01 {
	static int sum = 0;
	
	public static void main(String[] args) {
//		IntStream.rangeClosed(1,  5).forEach(new IntConsumer() {
//			@Override
//			public void accept(int a) {
//				System.out.println(a);
//			}
//		});
		
//		위 코드를 람다식으로 변경함, 직관적인 코드	
//		.forEach(IntConsumer action): 함수적 인터페이스 중 하나, forEach에 들어있음
		
//		IntStream.rangeClosed(1,  5).forEach(a->{ 
//			System.out.println(a);
//		});
//		System.out.println();
//		
//		IntStream.rangeClosed(1, 5).forEach(a->System.out.println(a));
		
		
		// forEach 안에서 sum을 쓰려면 정적멤버 "전역변수"로 sum을 만들어주면 가능
		IntStream.rangeClosed(1,  5).forEach(a->{
			sum += a;
		});
		System.out.println(sum);
	}

}
