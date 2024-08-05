<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userId = (String) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
        <form action="login.jsp" method="post"> 
            아이디:   <input type="text" name="id">&nbsp;&nbsp;
            비밀번호: <input type="password" name="pw">
            <input type="submit" value="로그인">
        </form>
</body>
</html>