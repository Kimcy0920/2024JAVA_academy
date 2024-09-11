package hello;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardService;
import command.CommandHandler;

// CommandHandler 인터페이스 구현하는 핸들러 "hello" 커맨드에 대한 처리 담당
public class DeleteHandler implements CommandHandler {

	@Override
	// CommandHandler 인터페이스의 process 메서드를 구현
	public String process(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		ListHandler listHandler = new ListHandler();
		
		int num = Integer.parseInt(req.getParameter("num"));
		new BoardService().deleteMsg(num);
		
		String redirect = listHandler.process(req, res);
		return redirect;
	}
	/*
	 * http://localhost:8080/chap18/controllerUsingFile?cmd=hello --> 결과값: 안녕하세요!
	 * cmd는 ControllerUsingFile.java에서 String command = request.getParameter("cmd");
	 * 해당 부분 HaspMap에서 hello 핸들러 찾기 --> CommandHandler handler =
	 * commandHandlerMap.get(command);
	 * 
	 */
}