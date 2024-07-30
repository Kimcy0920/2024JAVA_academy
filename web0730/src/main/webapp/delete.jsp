<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");

request.setCharacterEncoding("UTF-8");
String num = request.getParameter("num");
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");
String regtime = request.getParameter("regtime");
String hits = request.getParameter("hits");

String sql = "delete from board where num=?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, num);
pstmt.executeUpdate();
response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
</body>
</html>