<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String str = request.getParameter("str");
int num = Integer.parseInt(request.getParameter("num"));
int count = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>While Example</title>
</head>
<body>
<h1>While Example</h1>
<%
/*
while(num > count) {
	out.println(str);
	out.println("<br>");
	--num;
}
*/
for(int i=0; i<num; i++) {
	out.println(str);
	out.println("<br>");
}
%>

</body>
</html>