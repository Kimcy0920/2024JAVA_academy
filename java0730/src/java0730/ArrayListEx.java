package java0730;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListEx {

	public static void main(String[] args) {
//		[01]
//		int[] arr = new int[] {1,62,31,1,54,31}; // 집합
//		Set<Integer> set3 = new HashSet<>(arr); // 프리미티브 타입이기 때문에 Set으로 불가능, Integer
//
//		[02]		
//		Integer[] arr = new Integer[] {1,62,31,1,54,31}; // Integer로 변경해도 에러
//		Set<Integer> set3 = new HashSet<>(arr);
//
//		[03]		
		Integer[] arr = new Integer[] {1,62,31,1,54,31};
		List<Integer> list3 = Arrays.asList(arr); // ArrayList로 변경 후 arr배열 대입, Set으로 바꿔 출력
		Set<Integer> set3 = new HashSet<>(list3);
		
		// 리터럴 타입으로 Arraylist 작성
		List<Integer> list1 = Arrays.asList(1,62,31,1,54,31);
		List<String> list2 = Arrays.asList("홍길동","김길동","엄길동");		
		
		//반복문없이 출력해도 지원해주기 때문에 알아서 정리되어 출력됨
		System.out.println(list1);
		System.out.println(list2);
		
		Set<Integer> set1 = new HashSet<>(list1); // ArrayList를 Set으로 바꿔 중복된 값 제거
		System.out.println(set1);
		Set<String> set2 = new HashSet<>(list2);
		System.out.println(set2);
		
	}

}
