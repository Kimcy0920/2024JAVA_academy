<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
</head>
<body>

	<form action="updateProduct_2.jsp" method="post">
	<input type="hidden" name="id" value="${pdto.id}">
		<div>
			<label for="name">제품명:</label> <input type="text" id="name"
				name="name" value="${pdto.name}" required>
		</div>
		<div>
			<label for="description">설명:</label>
			<textarea id="description" name="description" value="${pdto.description}" required></textarea>
		</div>
		<div>
			<label for="price">가격:</label> <input type="text" id="price"
				name="price" value="${pdto.price}" required>
		</div>
		<div>
			<label for="stock">수량:</label> <input type="text" id="stock"
				name="stock" value="${pdto.stock}" required>
		</div>
		<div>
			<input type="submit" value="저장">
		</div>
	</form>
</body>
</html>