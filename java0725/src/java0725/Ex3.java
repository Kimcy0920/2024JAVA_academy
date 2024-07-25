package java0725;

public class Ex3 {

	public static void main(String[] args) {
		String s1 = args[0];
		System.out.println(s1);
		int num = 0;
		try {
			num = Integer.parseInt(s1);
		} catch (Exception e) {
			System.out.println("정수를 입력해 주시기 바랍니다.");
		}

	}

}
