package drive;

import board.BoardDAO;
import board.BoardDTO;

public class BoardTest3 {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getView(12);
		System.out.println(dto);
	}
}
