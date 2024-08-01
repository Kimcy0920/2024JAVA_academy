package sec01.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/Temp/test2.db");
//		추상클래스(부모)		자동타입변환(자식), 파일처리여서 파일아웃풋스트림
		
		byte[] array = {40,50,60};
//		byte a = 10;
//		byte b = 20;
//		byte c = 30;
		
		os.write(array);
//		os.write(a);
//		os.write(b);
//		os.write(c);
		
		os.flush();
		os.close();		
	}

}
