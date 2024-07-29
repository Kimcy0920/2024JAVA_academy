package sec01.exam03;

import java.util.HashMap;

public class KeyEx {

	public static void main(String[] args) {
		HashMap<Key, String> hashMap = new HashMap<>();
		
		hashMap.put(new Key(1), "홍길동");
		
		String value = hashMap.get(new Key(1));
		System.out.println(value);
		// hashCode 재정의를 하지 않아 Object의 hashCode 메소드가 사용됨
	}

}
