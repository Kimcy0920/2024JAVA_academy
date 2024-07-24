package sec01.exam06;

public class Button {
	OnClickListener listener;
	
	void setOnClickListener(OnClickListener listener) { // setter, 생성자아님
		this.listener = listener;
	}
	
	void touch() {
		listener.onClick();
	}
	
	static interface OnClickListener { // 내부, 중첩 인터페이스
		void onClick();
	}
	// 14-16코드 기능을 구현하면 실행됨
}
