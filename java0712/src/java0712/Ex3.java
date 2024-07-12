package java0712;

public class Ex3 {

	public static void main(String[] args) {
//		int[][] scores = new int[2][3]; // 2행 * 3열
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
		};
		
		System.out.println(array.length); // 전체 개수
		System.out.println(array[0].length); // 0번쨰 안에 개수
		System.out.println(array[1].length); // 1번째 안에 개수
		System.out.println(array[2].length); // 2번째 안에 개수
		
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array[i].length; j++) {
//				System.out.println(array[i][j]);
//			}
//		}
	}

}
