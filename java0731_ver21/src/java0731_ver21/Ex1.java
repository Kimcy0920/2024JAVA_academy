package java0731_ver21;

import java.util.HashMap;

public class Ex1 {
	public static void main(String[] args) {
		var map = new HashMap<String, Integer>(); // var 타입추론, 알아서 타입을 추정해서 넣어줌
		map.put("신", 86);
		map.put("당", 83);
		map.put("동", 89);
		map.put("신", 90);
		
		var vv = map.entrySet();
		for (var mm : vv) {
			var m1 = mm.getKey();
			System.out.print(m1 + ", ");
			var v1 = mm.getValue();
			System.out.println(v1);
		}
	}
}
// p.670 예제