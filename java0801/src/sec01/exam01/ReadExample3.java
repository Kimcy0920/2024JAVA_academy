package sec01.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample3 {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/Temp/test2.db");
		
		byte[] buf = new byte[5]; // buffer: 임시저장공간
		// 길이가 100인 배열 생성
		int data = is.read(buf, 2, 3);
		for(int i=0; i<buf.length; i++) {
			System.out.println(buf[i]);
		}
		
//		while (true) {
//			int data = is.read(buf);
////			is.read() - 4byte를 읽어서, int data - 1byte씩 저장
//			if(data == -1)
//				break;
//			for(int i=0; i<data; i++) {
//				System.out.println(buf[i]);
//			}
//		}
		is.close();
	}

}
