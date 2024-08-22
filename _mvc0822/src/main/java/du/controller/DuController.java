package du.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import du.db.MemberDao;
import du.db.MemberDto;

@WebServlet("/") // 모든 요청 다 받음
public class DuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
        String uri = request.getRequestURI();         //	/_mvc0822/
        String conPath = request.getContextPath();    //	/_mvc0822
        String com = uri.substring(conPath.length()); //	/
        
        if (com.equals("/")) {
        	view = "main.jsp";
        } else if (com.equals("/loginForm")) {
        	view = "/sign-in/loginForm.jsp";
        } else if (com.equals("/login")) {
        	request.setCharacterEncoding("utf-8");
        	String email = request.getParameter("email");
        	String password = request.getParameter("password");
        	System.out.println(email + ", " + password);
        	
        	MemberDto memberDto = new MemberDto(0, "", email, password, "");
        	MemberDao memberDao = new MemberDao();
        	int login = memberDao.isMember(memberDto);
        	if (login == 1) {
        		out.println("<script>alert('로그인 성공!');</script>");
        		memberDto = memberDao.findMember(memberDto);
        		System.out.println(memberDto);
        		session.setAttribute("customInfo", memberDto);
        		request.setAttribute("userLoggedIn", true);        		
        	} else {
        		out.println("<script>alert('로그인 실패!'); history.back()</script>");
        	}
        	view = "main.jsp";
        }
        
        // view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
        if (view.startsWith("redirect:")) {
            response.sendRedirect(view.substring(9));
            //        리다이렉팅 -> 페이지 이동
        } else {
            request.getRequestDispatcher(view).forward(request, response);
            //					디스패처 -> view=main.jsp	포워딩 떠넘기기	
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
