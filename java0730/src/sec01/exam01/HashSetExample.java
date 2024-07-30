package sec01.exam01;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("신창섭", 20));
		set.add(new Member("홍길동", 30));
		
		System.out.println("총 객채 수: " + set.size());
		
		for(Member mm : set) {
			System.out.println(mm);
		}

	}

}
