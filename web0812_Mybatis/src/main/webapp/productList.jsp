<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    <a href="${pageContext.request.contextPath}/registProduct.jsp">새 품목 생성</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="pdto" items="${products}">
            <tr>
                <td>${pdto.id}</td>
                <td>${pdto.name}</td>
                <td>${pdto.description}</td>
                <td>${pdto.price}</td>
                <td>${pdto.stock}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/product/${pdto.id}">장바구니에 추가</a>
                    <a href="${pageContext.request.contextPath}/selectOneProduct.jsp?id=${pdto.id}">수정</a>
                    <a href="${pageContext.request.contextPath}/deleteProduct.jsp?id=${pdto.id}">삭제</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>