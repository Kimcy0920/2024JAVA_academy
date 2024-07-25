package java0725;

public class Key {
	int number;
	
	Key(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Key) {
			Key ck = (Key) obj;
			if (number == ck.number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
//		return super.hashCode();
		return number; // 자식 클래스에서 hashCode 메소드를 재정의함.
	}
	
	
}
