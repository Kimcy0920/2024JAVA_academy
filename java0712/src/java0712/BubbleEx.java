package java0712;

public class BubbleEx {

	public static void printArr(int a[]) {
		for (int n : a) { // line 27-29 메서드로 바꿈
			System.out.print(n+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int a[] = {10, 3, 1, 4, 2}; // sort 정렬, 주로 배열에 사용
		
		for (int i = 0; i < a.length-1; i++) { // bubble sort, 뒤에서부터 비교하게 만듦
			for (int j = a.length-1; j > i; j--) {
				if (a[j] < a[j-1]) {
					int temp = a[j]; // swap
					a[j] = a[j-1];
					a[j-1] = temp;
					System.out.print("\t교환(j-1=" +(j-1)+", j="+j+")");
					printArr(a);
				}
			}
			printArr(a);
		}
//		for (int n : a) { // for-each, 향상된 for문 p.220
//			System.out.println(n);
//		}
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + ", ");
//		}
		System.out.println();
	}
}
