package drive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import board.BoardDAO;
import board.BoardDTO;

public class ReadEx {

	public static void main(String[] args) throws IOException {
//		FileReader reader = new FileReader("C:/Temp/test7.txt");
		String line = "";
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/board2.csv")); // 보조스트림
		while ((line = br.readLine()) != null) { // readLine: 한 라인씩 읽기
			String[] data = line.split(","); // split으로 csv파일의 각 줄을 쉼표로 분리
			
//			System.out.println(data[0]); // writer
//			System.out.println(data[1]); // title
//			System.out.println(data[2]); // content
			BoardDAO dao = new BoardDAO();
			BoardDTO dto = new BoardDTO(0, data[0], data[1], data[2], "", 0);
			dao.insertBoard(dto);
			System.out.println("ReadEx insert");
		}
		br.close();

	}

}
