<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>색상 선택</title>
</head>
<body>
<h1>If-else Example</h1>
<form action="colorResult.jsp" method="get">
이름: <input type="text" name="name"><p/>
색상: <select name="color">
	<option value="red" selected>red</option>
	<option value="blue">blue</option>
	<option value="yellow">yellow</option>
</select></p>
<input type="submit" value="보내기">
</form>
</body>
</html>