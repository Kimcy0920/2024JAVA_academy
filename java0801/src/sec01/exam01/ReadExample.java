package sec01.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/Temp/test1.db");
		
		while (true) {
			int data = is.read();
//			is.read() - 4byte를 읽어서, int data - 1byte씩 저장
			if(data == -1)
				break;
			System.out.println(data);
		}
		is.close();
	}

}
