<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// DB 접속
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
//-------------------------------------------------------

// 임시 저장 변수들
String sqlTmp = "";
String idTmp = "";
String nameTmp = "";
String ssnTmp = "";
String telTmp = "";
String balanceTmp = "";
//-------------------------------------------------------

// 매개변수들
request.setCharacterEncoding("UTF-8"); // 한글처리
String delete = request.getParameter("delete");
String find = request.getParameter("find"); // update 이전에 아이디 클릭 시 반드시 넘어오는 매개변수 값
String id = request.getParameter("id"); // null일 시 insert or update를 하지 않도록 함
String name = request.getParameter("name"); 
String ssn = request.getParameter("ssn");
String tel = request.getParameter("tel");
String balance = request.getParameter("balance");

// 아이디가 null이 아닌 경우 이미 입력된 아이디인지 조회
if (id != null) { // line 27 -> id
	sqlTmp = "select count(*) from account where id=?"; // 아이디 조회(있으면 1을 가져옴)
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	rs.next(); // 처음걸 가져오기 위해 사용
	int count = rs.getInt(1); // 0: insert, 1: update
	if(count == 1) {
		sqlTmp = "update account set name=?, ssn=?, tel=?, balance=? where id=?";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, name);
		pstmt.setString(2, ssn);
		pstmt.setString(3, tel);
		pstmt.setString(4, balance);
		pstmt.setString(5, id);
		pstmt.executeUpdate();
	} else {
		sqlTmp = "insert into account(id, name, ssn, tel, balance) values (?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, ssn);
		pstmt.setString(4, tel);
		pstmt.setString(5, balance);
		pstmt.executeUpdate();
	}
	
}

if (find != null) {
	sqlTmp = "select * from account where id=?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, find);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		idTmp = rs.getString("id");
		nameTmp = rs.getString("name");
		ssnTmp = rs.getString("ssn");
		telTmp = rs.getString("tel");
		balanceTmp = rs.getString("balance");
	}
}

if (delete != null) {
	sqlTmp = "delete from account where id=?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, delete);
	pstmt.executeUpdate();
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table { width: 600px; text-align: left; }
	th { width: 40px; background-color: gray; }
	tb { width: 40px; background-color: gray; }
</style>
<title>Account Table</title>
</head>
<body>
<form>
아&nbsp;이&nbsp;디: <input type="text" name="id" value="<%=idTmp %>"><br>
이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름: <input type="text" name="name" value="<%=nameTmp %>"><br>
주민번호: <input type="text" name="ssn" value="<%=ssnTmp %>"><br>
전화번호: <input type="text" name="tel" value="<%=telTmp %>"><br>
자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;금: <input type="text" name="balance" value="<%=balanceTmp %>"><br>
<input type="submit" value="입력/수정"><br><br>
</form>
<table border="1">
<tr>
	<th>아이디</th><th>이름</th><th>주민번호</th><th>번호</th><th>자금</th><th>삭제</th>
</tr>

<%
sqlTmp = "select * from account";
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) {
	idTmp = rs.getString("id");
	nameTmp = rs.getString("name");
	ssnTmp = rs.getString("ssn");
	telTmp = rs.getString("tel");
	balanceTmp = rs.getString("balance");
%>	

<tr>
	<!-- <a href=#></a> a태그(get방식) 링크로 바뀌어 클릭이 가능해짐 -->
	<td><a href="?find=<%=idTmp %>"><%=idTmp %></a></td><td><%=nameTmp %></td><td><%=ssnTmp %></td><td><%=telTmp %></td><td><%=balanceTmp %></td>
	<td><button onclick="location.href='?delete=<%=idTmp %>'">삭제</button></td>
</tr> <!-- button onclick 시에 delete로 idTmp가 넘어감. ?delete=1 -->

<%	
}
%>
</table>
</body>
</html>