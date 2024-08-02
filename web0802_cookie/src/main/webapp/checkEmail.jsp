<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String email = "";
boolean rememberMe = false;
Cookies cookies = new Cookies(request); // util.Cookies의 getValue사용
if (cookies.exists("email")) {
	email = cookies.getValue("email");
	rememberMe = true;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일을 쿠키에 저장</title>
</head>
<body>
<form action="checkEmailResult.jsp" method="post">
	<label for="email">Email:</label>
	<input type="email" id="email" name="email" value="<%=email %>" required><br>
	<input type="checkbox" id="remeberMe" name="rememberMe" <%= rememberMe ? "checked" : "" %>> <!-- rememberMe가 참이면 체크 / 거짓이면 공백 -->
	<label for="rememberMe">Remember Me</label><br>
	<input type="submit" value="제출">

</form>
</body>
</html>