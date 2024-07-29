package sec01.exam07;

public class ExitEx {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.print(i + " ");
			if(i == 5) {
				System.exit(0); // 9번 라인에서 강제 종료
				break; // i==5일 경우 for문 빠져나감
			}
		}
		System.out.println("마무리 코드"); // break 사용 시 13번 코드도 출력됨
	}

}
