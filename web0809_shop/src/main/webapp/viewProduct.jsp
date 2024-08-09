<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String id = request.getParameter("update");
request.setAttribute("id", Integer.parseInt(id));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="productList.jsp" method="post">
<input type="hidden" name="id" value="${id}">
<tr>
	<td>${product.id}</td>
    <td>${product.name}</td>
    <td>${product.description}</td>
    <td>${product.price}</td>
    <td>${product.stock}</td>
</tr>
<input type="submit" value="Back">
</form>
</body>
</html>