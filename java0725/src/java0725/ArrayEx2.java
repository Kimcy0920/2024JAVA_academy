package java0725;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEx2 {

	public static void main(String[] args) {
		Integer[] array = {3, 1, 13, 2, 8, 5, 1};
		Comparator<Integer> c = new Comparator<Integer>() {
		// 역순으로 나옴
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
			
		};
		
		Arrays.sort(array, c); // sort 정렬에 Comparator 추가
		System.out.println(Arrays.toString(array)); // 문자열 형태로 찍음
		
		for(int n : array) {
			System.out.print(n + " ");
		}

	}

}
