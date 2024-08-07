<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("vv", "홍길동");
String ss = (String) session.getAttribute("vv");
request.setAttribute("kk", "KIMCHANGYONG");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${'1'+100.98 }<br> <!-- 문자열과 정수타입 자동 형 변환 -->
${vv == '홍길동'}<br>
${kk }<br>
<%
if (false) {
%>
<%=ss %>
<%
}
%>
</body>
</html>