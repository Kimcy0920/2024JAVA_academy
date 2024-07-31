package java0731;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriter2 {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:/Temp/file");
		if(dir.exists() == false) { // 파일이 없으면 생성
			dir.mkdirs();
			System.out.println(dir + " 경로에 파일 생성");
		}
		
		Writer writer = new FileWriter("C:/Temp/file/data.txt");
		String str = "안녕하세요"; // str에 문자열 값 넣기
		writer.write(str); // 문자열 전체 출력
		writer.flush(); // 출력 버퍼에 잔류하는 문자열 출력
		writer.close(); // 출력 스트림 닫기
	}

}
// 파일 생성 후 안녕하세요를 출력하는 텍스트파일 만들기