package java0730_re;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("저장된 객체 수: " + size);
		System.out.println();
		
		set.remove(2); // 인덱스번호 2번 삭제
		set.remove(2); // 앞당겨진 인덱스 2번 삭제
		set.remove("iBATIS"); // 값이 iBATIS인 인덱스 삭제
		
		System.out.println("저장된 객체들 출력");
		for (String str : set) { // Java는 중복되어 하나만 출력됨
			System.out.println(str);
		}
		
		System.out.println();
		set.clear();
		if(set.isEmpty()) {
			System.out.println("비어 있음");
		}
	}

}
