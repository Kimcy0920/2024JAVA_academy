<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateProduct_2.jsp" method="post">
	<input type="hidden" name="id" value="${product.id}">
		<div>
			<label for="name">제품명:</label> <input type="text" id="name"
				name="name" values=${product.name } required>
		</div>
		<div>
			<label for="description">설명:</label>
			<textarea id="description" name="description" values=${product.description } required></textarea>
		</div>
		<div>
			<label for="price">가격:</label> <input type="text" id="price"
				name="price" values=${product.price } required>
		</div>
		<div>
			<label for="stock">수량:</label> <input type="text" id="stock"
				name="stock" values=${product.stock } required>
		</div>
		<div>
			<input type="submit" value="Edit Product">
		</div>
	</form>
</body>
</html>