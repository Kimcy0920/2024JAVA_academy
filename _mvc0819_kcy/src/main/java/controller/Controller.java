package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardDTO;
import service.Service;

@WebServlet("/")
public class Controller extends HttpServlet {
	// 시작위치, 모든 요청은 컨트롤러에서 받아서 처리함
    private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                                 throws ServletException, IOException {
        String view = null;
        HttpSession session = request.getSession();
//      PrintWriter out = response.getWriter();

        // URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();
        String com = uri.substring(conPath.length());
//        response.setCharacterEncoding("UTF-8");

//        // 메인 화면 동작
//        if (com.equals("/main") || (com.equals("/"))) {
//        	view = "main.jsp";
//        } 
//        
//        // 로그인 동작 수행
//        else if (com.equals("/login")) {
//        	String id = request.getParameter("id");
//        	String pw = request.getParameter("pw");
//
//        	memDAO dao = new memDAO();
//        	memDTO dto = dao.memLogin(new memDTO(id, pw, "", ""));
//
//        	if (dto != null) {
//        		session.setAttribute("name", dto.getName());
//        		view = "main.jsp";
//        	} else {
//        	    out.println("아이디 또는 비밀번호가 틀립니다!");
//        	    out.close();
//        		view ="login_form.jsp";
//        	}
//        }
        
        // 주어진 URL에 따라 지정된 동작 수행
        if (com.equals("/") || com.equals("/list")) {
            String tmp = request.getParameter("page");
            int pageNo = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 1;

            request.setAttribute("msgList",
                    new Service().getMsgList(pageNo));
            request.setAttribute("pgnList",
                    new Service().getPagination(pageNo));
            view = "/list.jsp";

        } else if (com.equals("/view")){
            int num = Integer.parseInt(request.getParameter("num"));

            request.setAttribute("msg", new Service().getMsg(num));
            view = "/view.jsp";

        } else if (com.equals("/write")){
            String tmp = request.getParameter("num");
            int num = (tmp != null && tmp.length() > 0)
                    ? Integer.parseInt(tmp) : 0;

            BoardDTO dto = new BoardDTO();
            String action = "insert";

            if (num > 0) {
                dto = new Service().getMsgForWrite(num);
                action = "update?num=" + num;
            }

            request.setAttribute("msg", dto);
            request.setAttribute("action", action);
            view = "/write.jsp";

        } else if (com.equals("/insert")){
            request.setCharacterEncoding("utf-8");
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");
            String regtime = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);

            try {
                new Service().writeMsg(writer, title, content, regtime);
                view = "redirect:list";

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "/errorBack.jsp";
            }

        } else if (com.equals("/update")){
            request.setCharacterEncoding("utf-8");
            int num = Integer.parseInt(request.getParameter("num"));
            String writer  = request.getParameter("writer" );
            String title   = request.getParameter("title"  );
            String content = request.getParameter("content");

            try {
                new Service().updateMsg(writer, title, content, num);
                view = "redirect:list";

            } catch(Exception e) {
                request.setAttribute("errorMessage", e.getMessage());
                view = "/errorBack.jsp";
            }

        } else if (com.equals("/delete")){
            int num = Integer.parseInt(request.getParameter("num"));

            new Service().deleteMsg(num);
            view = "redirect:list";
        }

        // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
        } else {
            request.getRequestDispatcher(view).forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                                  throws ServletException, IOException {
        doGet(request, response);
    }
}