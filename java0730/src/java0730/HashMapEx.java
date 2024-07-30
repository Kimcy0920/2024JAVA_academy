package java0730;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		Map<String, Integer> map =  new HashMap<>();
		//	Key		value			HashMap 생성
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 엔트리 수: " + map.size());
		// 총 엔트리 수: 3 -> ("홍길동")Key가 중복되어 4가 아닌 3이 나옴
		
		System.out.println(map.get("홍길동"));
		System.out.println("------------------------------------------");
		
		Set<String> ks = map.keySet(); // keySet -> Map인터페이스가 갖고있음, key에 해당하는 값만 갖고있음
		// 변수 ks에 keySet
//		제너레이터(String)+새 변수명(str) : Set 변수명(ks)
		// iterator없이 향상된 for문으로 Map의 key, value 출력
		for (String str : ks) {
			System.out.println(str);
			System.out.println(map.get(str));
		}
		System.out.println("------------------------------------------");
		
		Set<Map.Entry<String, Integer>> es = map.entrySet(); // entrySet 다 들어있음
		
		//	Set안에 제너레이터 내용(Map.Entry<String, Integer>)+새 변수명(kv) : Set 변수명(es)
		for (Map.Entry<String, Integer> kv : es) {
			String k = kv.getKey();
			Integer v = kv.getValue();
			String msg = MessageFormat.format("키는 {0}이고, 값은 {1}이다.", k, v);
			// MessageFormat 문자열로 출력하기 println보다 편함
			System.out.println(msg);
		}
	}

}
