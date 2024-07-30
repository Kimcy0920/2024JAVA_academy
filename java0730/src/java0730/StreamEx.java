package java0730;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class StreamEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>(); // ArrayList
		list.add(new Student("Ken", 100));
		list.add(new Student("Shin", 60));
		list.add(new Student("Kim", 80));
		
		// Ken, 100부터 시작해서 필터를 거쳐 카운트 <- 반복
		// Shin, 60은 필터에서 걸러져서 70점 이상은 2명
		long num = list.stream().filter(s->s.getScore() >= 70).count();
		System.out.println("70점 이상은 " + num + "명");
		
		System.out.println("----------------");
		
//		점수가 70 미만이면 출력하지 않음
		System.out.println("스트림방식");
		list.stream() // 스트림
		.filter(s->s.getScore() >= 70) // 중간작업(필터)
		.forEach(s->System.out.println(s.getName() + ", " + s.getScore())); // 최종작업
		
		System.out.println("----------------");
//		for (Student st : list) {
//			if (st.getScore() < 70) {
//				list.remove(st);
//			}
//		}
//		
//		// list 사이즈만큼 반복, list를 하나씩 불러들이고 스코어에 저장된 값을 비교 70미만이면 삭제
//		for(int i=0; i<list.size(); i++) {
//			if (list.get(i).getScore() < 70) {
//				list.remove(i);
//			}
//		}
		
		System.out.println("람다식");
		list.stream().forEach(a->{
			String msg = MessageFormat.format("{0}, {1}", a.getName(), a.getScore());
			System.out.println(msg);
		});
		
//		System.out.println("[향상된 for문/MessageFormat방식]");
//		for (Student st : list) {
//			String msg = MessageFormat.format("{0}, {1}", st.getName(), st.getScore());
//			System.out.println(msg);
//		}
	}

}
