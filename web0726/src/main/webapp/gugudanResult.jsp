<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int num = Integer.parseInt(request.getParameter("gugu"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>

<table border="1">
<tr><th><%=num %>단 출력</th></tr>
<%
for(int i=1; i<=9; i++) {
%>
<tr><td><%=num %> X <%=i %> = <%=i*num %></td></tr>
<%	
}
%>

</table>
</body>
</html>