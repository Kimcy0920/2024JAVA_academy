package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstLogin")
public class FirstLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstLogin() {
        super();
        
    }

    // request 기본객체, response 기본객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // request 객체에서 글씨가 깨지는 것을 방지
		String str1 = request.getParameter("name");
		String str2 = request.getParameter("ssn"); // input type="text" <- nn에 입력한 값을 문자열 str에 저장
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from account where name = ? and ssn = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("ssn"));
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id1 = rs.getInt("id");
				String name1 = rs.getString("name");
				String ssn1 = rs.getString("ssn");
				String tel1 = rs.getString("tel");
				int balance1 = rs.getInt("balance");
				String str = String.format("%d, %s, %s, %s, %d\n", id1, name1, ssn1, tel1, balance1);
				System.out.println(str);
				
				LoginTestSession.id = id1;
				LoginTestSession.name = name1;
				LoginTestSession.ssn = ssn1;
				LoginTestSession.tel = tel1;
				LoginTestSession.balance = balance1;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath()); // ContextPath: 프로젝트명
		response.setContentType("text/html;charset=utf8"); // (웹페이지) response 객체 글씨가 깨지는 것을 방지
		PrintWriter out = response.getWriter(); // getWriter로 받아오기전에 setContentType를 이용해 한글이 깨지지 않게함
		
		out.println("<html>");
		if(LoginTestSession.ssn.equals(str2) && LoginTestSession.name.equals(str1)) {
			out.println("<h1>" + LoginTestSession.name + "님 환영합니다.</h1>"); // h1태그안에 str 문자열 출력
		} else {
			out.println("<h1>잘못된 정보 입니다.</h1>");
		}
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
