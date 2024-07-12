package java0712;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoEx {

	public static void main(String[] args) {
//		int[] lotto = new int[6]; // 인덱스 0~5 (개수 6개)
		Random rand = new Random();
		Set<Integer> lottoSet = new HashSet<>(); // 중복을 허용하지 않는 Set(집합) 사용

		while(lottoSet.size() < 6) {
			int number = rand.nextInt(45) + 1; // 1~45 사이의 난수 생성
			lottoSet.add(number);
		}
		
//		lottoSet.add(14); // 14 2개, 중복되어 있으면 size를 1개로 인식
//		lottoSet.add(14);
//		lottoSet.add(7);
//		System.out.println(lottoSet.size());
		System.out.println(lottoSet);
	}

}
