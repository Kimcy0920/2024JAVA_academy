package java0730;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamEx2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Ken", 100));
		list.add(new Student("Shin", 60));
		list.add(new Student("Kim", 80));
		
		
		// Collection.sort 리스트의 score의 크기에 따른 정렬
		Collections.sort(list, (s1, s2)->Integer.compare(s2.getScore(), s1.getScore())); // 객체 배열의 경우는 Arrays.sort 사용
		System.out.println(list);
		System.out.println("--------------------------------------------------------------------------------------------");
		
		// stream방식으로 출력
		list.stream()
		.forEach(s->{
			System.out.println(s.getName() + ", " + s.getScore());
		});
	}

}
