package java0731;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;

public class Ex7 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
//		double avg = list.stream()
//				.mapToInt(Integer::intValue) // Integer.wrapper.class 안에 있는 메소드 intValue mapping
//				.average()
//				.getAsDouble();
//			NoSuchElementException. NPE와 유사한 에러코드
//		System.out.println(avg);
		
//		Optional 처리 1번째 방식
		OptionalDouble avg = list.stream()
				.mapToInt(Integer::intValue)
				.average();
		if (avg.isPresent()) { // isPresent 조건
			System.out.println(avg.getAsDouble());
		} else {
			System.out.println("값이 없음");
		}
		
//		Optional 처리 2번째 방식
		double avg1 = list.stream()
				.mapToInt(Integer::intValue)
				.average().orElse(0.0);
		System.out.println(avg1);
		
//		Optional 처리 3번째 방식
		list.stream().mapToInt(Integer::intValue)
			.average()
			.ifPresent(a->{ // ifPresent 조건
				System.out.println(a);
			});
	}

}
