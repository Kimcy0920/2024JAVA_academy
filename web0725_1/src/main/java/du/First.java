package du;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public First() {
        super();
        
    }

    // request 기본객체, response 기본객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // request 객체에서 글씨가 깨지는 것을 방지
		String str = request.getParameter("ssn"); // input type="text" <- nn에 입력한 값을 문자열 str에 저장
		String str2 = request.getParameter("name");
		LoginSession.name = str2;
//		response.getWriter().append("Served at: ").append(request.getContextPath()); // ContextPath: 프로젝트명
		response.setContentType("text/html;charset=utf8"); // (웹페이지) response 객체 글씨가 깨지는 것을 방지
		PrintWriter out = response.getWriter(); // getWriter로 받아오기전에 setContentType를 이용해 한글이 깨지지 않게함
		out.println("<html>");
		out.println("<h1>음...흠!음...으음.</h1>");
		if(LoginSession.ssn.equals(str)) {
			out.println("<h1>" + LoginSession.name + "님 환영합니다.</h1>");
		} else {
			out.println("<h1>잘못된 ssn정보 입니다.</h1>");
		}
//		out.println("<h1>" + LoginSession.name + "님 환영합니다.</h1>"); // h1태그안에 str 문자열 출력
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
