package templateMethod;

public abstract class AbstractDisplay {
	// open, print, close는 하위 클래스에 *구현을 맡기는* 추상 메소드
	public abstract void open();
	public abstract void print();
	public abstract void close();
	
	// Display는 abstractDisplay에서 구현하는 메소드
	public final void display() { // final이 붙어서 *재정의 할 수 없음*
		open();
		for(int i=0; i<5; i++) {
			print();
		}
		close();
	}
}
