package board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ReplyArticleService;
import mvjsp.chap17.board.service.ReplyingRequest;

public class ReplyHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		
		req.setCharacterEncoding("euc-kr");
		
		String writerName = req.getParameter("writerName");
		String title = req.getParameter("title");
		String password = req.getParameter("password");
		String content = req.getParameter("content");
		
		ReplyingRequest replyingRequest = new ReplyingRequest(writerName, password, title, content);
		
		try {
			Article postedArticle = ReplyArticleService.getInstance().
					reply(replyingRequest);
			req.setAttribute("postedArticle", postedArticle);
			return "/WEB-INF/view//reply_success.jsp";
			
		} catch(Exception ex) {
			
			req.setAttribute("replyException", ex);
			return "/WEB-INF/view/reply_error.jsp";
		}
	}

}
