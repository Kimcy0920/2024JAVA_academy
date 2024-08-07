<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("kk", "김판용");
	request.setAttribute("gugu", "7");
/*
	Dispatch(포워드 방식)
	client가 요청을 한 걸 from이 받고, to에서 응답함.
	주소는 from.jsp지만, 웹페이지는 to.jsp의 화면 출력됨.
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>From Page</h1>
<jsp:forward page="to.jsp"/>
</body>
</html>