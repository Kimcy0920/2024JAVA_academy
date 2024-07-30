package sec01.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("저장된 객체 수: " + size);
		System.out.println();
		
		String skill = list.get(2); // 인덱스 번호로 호출
		System.out.println("인덱스번호로 호출: " + skill);
		System.out.println();

		System.out.println("저장된 객체들 출력");
		for (int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		System.out.println();
		
		list.remove(2); // 인덱스번호 2번 삭제
		list.remove(2); // 앞당겨진 인덱스 2번 삭제
		list.remove("iBATIS"); // 값이 iBATIS인 인덱스 삭제
		
		System.out.println("저장된 객체들 출력");
		for (String str : list) {
			System.out.println(str);
		}
	}

}
