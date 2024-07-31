package java0731;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStream {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/Temp/file/data.txt");
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out::println); // static 메소드를 사용해 읽어옴
		
		System.out.println("-------"); // 위아래 코드 다 파일 읽어오는 코드
		
		File file = path.toFile();
		BufferedReader br = new BufferedReader(new FileReader(file)); // BufferedReader: 보조 리더
		stream = br.lines(); // line으로 읽어오는 코드
		stream.forEach(System.out::println);
		
	}

}
// MyFileReader를 Stream방식으로 바꿈
// 파일 읽는게 목적이라면 Reader보다 향상된 방식