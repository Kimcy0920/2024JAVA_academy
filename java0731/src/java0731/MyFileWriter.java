package java0731;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriter {

	public static void main(String[] args) throws IOException {
		File dir = new File("C:/Temp/text"); // 해당 경로에 위치한 파일 열기
		File file1 = new File("C:/Temp/text/file1.txt");
		
		if(dir.exists() == false) { // 파일이 없으면 생성
			dir.mkdirs();
			System.out.println(dir + " 경로에 text " + "생성");
		}
		
//		if (file1.exists() == false) {
//			file1.createNewFile();
//			System.out.println(file1 + "경로에 file1 " + "생성");
//		}
		
		Writer writer = new FileWriter("C:/Temp/text/file1.txt");
		String str = "가나다라마바사아자차카타파하"; // str에 문자열 값 넣기
		writer.write(str); // 문자열 전체 출력
		writer.flush(); // 출력 버퍼에 잔류하는 문자열 출력
		writer.close(); // 출력 스트림 닫기
	}

}
// p.662 File -> p.629 Writer -> 