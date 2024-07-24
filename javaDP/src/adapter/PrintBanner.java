package adapter;

public class PrintBanner extends Banner implements Print {
	// 필드 없음
	
	// 부모가 생성자를 만들어서 자식도 만들어야함
	public PrintBanner(String string) {
		super(string);
		
	}

	@Override
	public void printWeak() {
		this.showWithParen();
		
	} // 인터페이스 printWeak() 구현을 하는데 부모에서 showWithParen() 메소드를 가져다 씀

	@Override
	public void printString() {
		this.showWithAster();
		
	}
	
}
