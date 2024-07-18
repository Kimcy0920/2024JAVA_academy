package exam;

public interface Role {
	public static final int MAX = 10;
	int MIN = 0; // 대문자로 작성 시 public static final 생략가능
// 필드가 아님
	
	public abstract void doIt(); // 추상클래스
}
