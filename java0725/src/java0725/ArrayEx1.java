package java0725;

import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		int[] array = {3, 1, 13, 2, 8, 5, 1};
		
		Arrays.sort(array); // sort 정렬 가능
		System.out.println(Arrays.toString(array)); // 문자열 형태로 찍음
		
		for(int n : array) {
			System.out.print(n + " ");
		}

	}

}
