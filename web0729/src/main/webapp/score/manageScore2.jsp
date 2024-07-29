<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 데이터베이스 접속
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
//-------------------------------------------------------

//임시 저장 변수들
String numTmp = "";
String nameTmp = "";
String korTmp = "";
String engTmp = "";
String mathTmp = "";
String sqlTmp = "";
//-------------------------------------------------------

// 매개변수들
request.setCharacterEncoding("UTF-8");        // 한글 처리
String find = request.getParameter("find");   // update 이전에 학번 클릭 시 반드시 넘어오는 매개변수 값
String num = request.getParameter("num");     // null이면 insert나 update를 하지 않도록 함
String name = request.getParameter("name");
String kor = request.getParameter("kor");
String eng = request.getParameter("eng");
String math = request.getParameter("math");
String delete = request.getParameter("delete");
//-------------------------------------------------------

// 학번이 null이 아닌 경우 이미 입력된 학번인지 조회
if (num != null) { // line28
	sqlTmp = "select count(*) from score where num = ?"; // 학번 조회(있으면 1을 가져옴)
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, num);
	ResultSet rs = pstmt.executeQuery();
	rs.next(); // 처음걸 가져오기 위해서 사용
	int count = rs.getInt(1); // 0: insert, 1: update
	if (count == 1) {
		sqlTmp = "update score set name=?, kor=?, eng=?, math=? where num=?";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, name);
		pstmt.setString(2, kor);
		pstmt.setString(3, eng);
		pstmt.setString(4, math);
		pstmt.setString(5, num);
		int result = pstmt.executeUpdate();
	} else {
		sqlTmp = "insert into score(num, name, kor, eng, math) values (?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sqlTmp);
		pstmt.setString(1, num);
		pstmt.setString(2, name);
		pstmt.setString(3, kor);
		pstmt.setString(4, eng);
		pstmt.setString(5, math);
		int result = pstmt.executeUpdate();
	}
}

if (find != null) {
	sqlTmp = "select * from score where num=?";
	pstmt = conn.prepareStatement(sqlTmp);
	pstmt.setString(1, find);
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		numTmp = rs.getString("num");
		nameTmp = rs.getString("name");
		korTmp = rs.getString("kor");
		engTmp = rs.getString("eng");
		mathTmp = rs.getString("math");
	}
}

if (delete != null) {
	sqlTmp = "delete from score where num =?";
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
        th    { width: 40px; background-color: cyan; }
    </style>
<title>학생 점수 관리 프로그램</title>
</head>
<body>
<form>
	학번: <input type="text" name="num" value="<%=numTmp %>"><br> <!-- update -->
	이름: <input type="text" name="name" value="<%=nameTmp %>"><br>
    국어: <input type="text" name="kor" value="<%=korTmp %>"><br>
    영어: <input type="text" name="eng" value="<%=engTmp %>"><br>
    수학: <input type="text" name="math" value="<%=mathTmp %>"><br>
    <input type="submit" value="입력/수정">
</form>
<table>
<tr>
        <th>번호</th><th>이름</th>
        <th>국어</th><th>영어</th><th>수학</th>
        <th>총점</th><th>평균</th><th>삭제</th>
</tr>

<%

sqlTmp = "select * from score"; // 항상
pstmt = conn.prepareStatement(sqlTmp);
ResultSet rs = pstmt.executeQuery();

while(rs.next()) { // select 용도로 사용됨
	numTmp = rs.getString("num");
	nameTmp = rs.getString("name");
	korTmp = rs.getString("kor");
	engTmp = rs.getString("eng");
	mathTmp = rs.getString("math");
	int tot = Integer.parseInt(korTmp)+Integer.parseInt(engTmp)+Integer.parseInt(mathTmp);
	double avg = tot / 3.0;
	
%>
<!-- <a href=#></a> a태그(get방식) 링크로 바뀌어 클릭이 가능해짐 -->
	<tr>
	<td><a href="?find=<%=numTmp %>"><%=numTmp %></a></td><td><%=nameTmp %></td><td><%=korTmp %></td><td><%=engTmp %></td>
	<td><%=mathTmp %></td><td><%=tot %></td><td><%=avg %></td><td><button onclick="location.href='?delete=<%=numTmp%>'">삭제</button></td>
	</tr>															<!-- button onclick 시에 delete로 numTmp가 넘어감. ?delete=2470016 -->

<%
}
%>

</table>
</body>
</html>