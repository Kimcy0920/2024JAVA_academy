package java0725;

import java.util.Arrays;

public class ArrayEx3 {

	public static void main(String[] args) {
		int[] array = {1,1,4,5,7,8,11,12,17,21,24}; // 정렬이 된 상태
		int found = Arrays.binarySearch(array, 5);
		// Arrays.binarySearch는 정렬이 되어 있는 상태의 배열에서 찾는 숫자가 몇 번째(index)에 있는지
		System.out.println(found);
		
		int[] array2 = {3,1,13,2,8,5,1}; // 정렬이 안된 상태
		int found2 = Arrays.binarySearch(array2, 8);
		System.out.println(found2); // 못 찾음
	}

}
