package sec01.exam01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("가나다", 75); // key, value
		map.put("라마바", 85);
		map.put("사아자", 95);
		map.put("차카파", 65);
		System.out.println("총 엔트리 수: " + map.size());

		System.out.println("가나다: " + map.get("가나다")); // key값으로 value 찾기
		System.out.println();
		
		Set<String> keySet = map.keySet();
		for (String set : keySet) {
			System.out.println(set + ", " + map.get(set));
		}
		System.out.println();
		
		map.remove("가나다");
		System.out.println("총 엔트리 수: " + map.size());
		System.out.println();
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> mm : entrySet) {
			String str = mm.getKey();
			Integer in = mm.getValue();
			System.out.println(str + ", " + in);
		}
	}

}
