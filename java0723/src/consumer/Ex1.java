package consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Ex1 {
	
	public static void main(String[] args) {
		Consumer<String> consumer = t->System.out.println(t);
		// 인터페이스<제네릭>
		consumer.accept("test");
		
		BiConsumer<String, String> consumer2 = (x, y)->System.out.println(x+y); // 제네릭 2개인 경우 BiConsumer
		consumer2.accept("혼자 공부하는", "자바");
	}
}
