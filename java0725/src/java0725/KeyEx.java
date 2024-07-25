package java0725;

import java.util.HashMap;

public class KeyEx {

	public static void main(String[] args) {
//		HashMap<Integer, String> hashMap = new HashMap<>();
//		hashMap.put(1, "홍길동");
//		String val = hashMap.get(1);
//		System.out.println(val);
		
		Key key1 = new Key(100);
		Key key2 = new Key(100);
		System.out.println(key1.hashCode()); // 해시코드 값이 다름
		System.out.println(key2.hashCode());
		if(key1.equals(key2)) { // Key1과 Key2에 100은 동일해서 같다고 나옴
			System.out.println("key1과 key2는 같다.");
		} else {
			System.out.println("key1과 key2는 다르다.");
		}
		
		HashMap<Key, String> hashMap = new HashMap<>();
//		      key(번호), value(저장할것)			<내용 생략 가능>
		hashMap.put(new Key(1), "홍길동");
		String val = hashMap.get(new Key(1));
		System.out.println(val);
	}
}
