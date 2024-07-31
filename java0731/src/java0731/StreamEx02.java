package java0731;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class StreamEx02 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 90),
				new Student("에드워드", 85),
				new Student("엄복동", 95)
		);
		
//		int sum = list.stream().mapToInt(s->s.getScore()).sum();
		int sum = list.stream().mapToInt(Student::getScore).sum(); // 메소드 참조 방식
		// 
		System.out.println(sum);
		System.out.println("---------------------");
		
		// double avg는 에러발생, 타입을 OptionalDouble 변경 혹은 .getAsDouble();
		double avg1 = list.stream().mapToInt(Student::getScore).average().getAsDouble();
		System.out.println(avg1);
		System.out.println("---------------------");
		
		OptionalDouble avg2 = list.stream().mapToInt(Student::getScore).average();
		System.out.println(avg2);
		// Optional - NullPointException을 회피하기 위함
	}

}

/*
 * 스트림 순서
 * 
*/