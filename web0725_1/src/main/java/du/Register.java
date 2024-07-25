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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
        
    }

    // request 기본객체, response 기본객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // request 객체에서 글씨가 깨지는 것을 방지
		int balance = 0;
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into account (name, ssn, tel, balance) values (?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("ssn"));
			pstmt.setString(3, request.getParameter("tel"));
			pstmt.setInt(4, balance);
			
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "건 insert 성공!");
		
			RegisterSession.name = request.getParameter("name");
			RegisterSession.ssn = request.getParameter("ssn");
			RegisterSession.tel = request.getParameter("tel");
			RegisterSession.balance = balance;
				
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath()); // ContextPath: 프로젝트명
		response.setContentType("text/html;charset=utf8"); // (웹페이지) response 객체 글씨가 깨지는 것을 방지
		PrintWriter out = response.getWriter(); // getWriter로 받아오기전에 setContentType를 이용해 한글이 깨지지 않게함
		
		out.println("<html>");
		out.println("<h1>" + RegisterSession.name + ", " + RegisterSession.ssn + ", " + RegisterSession.tel + ", " + "</h1>");
		out.println("<h1>" + RegisterSession.name + "님 회원가입을 환영합니다. </h1>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
