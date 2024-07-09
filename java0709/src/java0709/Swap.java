package java0709;

/**
 * 안녕하세요 나는 김창용입니다. 
 */
public class Swap {

	/**
	 * @param a
	 * @param b
	 */
	public static void swap(int a, int b) {
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		System.out.printf("x = %d, y = %d\n", a, b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		
		System.out.printf("x = %d, y = %d\n", x, y);
		swap(x, y);
		
//		스와핑 x, y 값 바꾸기		
//		int temp;
//		
//		temp = y;
//		y = x;
//		x = temp;
//		System.out.printf("x = %d, y = %d\n", x, y);
	}
}
