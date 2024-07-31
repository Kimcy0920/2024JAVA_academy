package drive;

import java.util.List;

import board.BoardDAO;
import board.BoardDTO;

public class BoardTest2 {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO(0, "동생", "에드워드", "add...word...oppa...", "", 0);
		dao.insertBoard(dto);
		System.out.println("입력 성공");

	}

}
