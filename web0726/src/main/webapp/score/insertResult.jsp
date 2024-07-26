<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int num1 = Integer.parseInt(request.getParameter("num"));
String name1 = request.getParameter("name");
int kor1 = Integer.parseInt(request.getParameter("kor"));
int eng1 = Integer.parseInt(request.getParameter("eng"));
int math1 = Integer.parseInt(request.getParameter("math"));

String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
String sql = "insert into score(num, name, kor, eng, math) values (?, ?, ?, ?, ?)";
pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, num1);
pstmt.setString(2, name1);
pstmt.setInt(3, kor1);
pstmt.setInt(4, eng1);
pstmt.setInt(5, math1);
int result = pstmt.executeUpdate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertResult</title>
</head>
<body>
<%=result %>건 추가!
<%=num1 %>, <%=name1 %>, 국어:<%=kor1 %>점, 영어:<%=eng1 %>점, 수학:<%=math1 %>점 추가
</body>
</html>