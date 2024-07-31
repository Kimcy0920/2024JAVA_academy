package java0731;

import java.util.Arrays;
import java.util.List;

public class Ex5 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍박사", Member.MALE, 30),
				new Member("엄복동", Member.MALE, 27),
				new Member("김퐌용", Member.FEMALE, 19),				
				new Member("양금모", Member.FEMALE, 22)				
				);
		double avg1 = list.stream().mapToInt(a->a.getAge()).average().orElse(0);
		System.out.println(avg1); // 전체 평균나이
		double avg2 = list.stream().filter(x->x.getSex() == Member.MALE).mapToInt(Member::getAge).average().orElse(0); // orElse(0): 값이 없으면 0으로
		System.out.println(avg2); // 남자 평균나이
		double avg3 = list.stream().filter(x->x.getSex() == Member.FEMALE).mapToInt(a->a.getAge()).average().orElse(0); // filter (predicate) = true or false
		System.out.println(avg3); // 여자 평균나이
	}
}
