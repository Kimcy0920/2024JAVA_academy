package sec01.exam07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadEx {

	public static void main(String[] args) throws IOException {
//		FileReader reader = new FileReader("C:/Temp/test7.txt");
		String line = "";
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/board1.csv")); // 보조스트림
		while ((line = br.readLine()) != null) {
			String[] data = line.split(", ");
			
			for(String element : data) {
				System.out.println(element + " ");
			}
			System.out.println();
		}
		br.close();

	}

}
