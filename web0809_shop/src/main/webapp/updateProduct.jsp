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
	<form action="updateProduct_2.jsp" method="post">
	<input type="hidden" name="id" value="${id}">
		<div>
			<label for="name">제품명:</label> <input type="text" id="name"
				name="name" required>
		</div>
		<div>
			<label for="description">설명:</label>
			<textarea id="description" name="description" required></textarea>
		</div>
		<div>
			<label for="price">가격:</label> <input type="text" id="price"
				name="price" required>
		</div>
		<div>
			<label for="stock">수량:</label> <input type="text" id="stock"
				name="stock" value="" required>
		</div>
		<div>
			<input type="submit" value="Edit Product">
		</div>
	</form>
</body>
</html>