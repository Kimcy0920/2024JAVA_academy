<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String color = request.getParameter("color");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>색상 선택</title>
</head>
<body bgcolor="<%=color %>">
<h1>이름: <%=name %></h1><br>
<h1>색상: <%=color %></h1>
</body>
</html>