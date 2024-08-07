<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("name", "홍길동");
	request.setAttribute("money", 5000);
	request.setAttribute("dataList", new String[] {"a,", "b,", "c"});
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSTL 조건문 -->
<c:if test="${name == '홍길동' }">
	이름은 홍길동입니다.<br><br>
</c:if>
잔고: ${money}원 <br>
<c:choose>
	<c:when test="${money >= 10000}">
		10000이상 보유중
	</c:when>
	<c:when test="${money > 0}">
		0 이상 보유중
	</c:when>
	<c:otherwise>
		거지
	</c:otherwise>
</c:choose>
<br><br>

<!-- JSTL 반복문 -->
<c:forEach var="count" begin="0" end="30" step="3">
	${count}
</c:forEach>
<br><br>

<!--${sum = 0} 웹페이지에도 보임, ;''를 붙이면 표현식을 ''로 웹페이지에서 안보임-->
${sum = 0; ''}
<c:forEach var="i" begin="1" end="10"> <!--i를 1부터 10까지-->
${sum = sum + i; ''}
</c:forEach>
1부터 10까지의 합: ${sum}
<ul>
<li>
<c:forEach var="i" begin="1" end="9">
	4 * ${i} = ${4*i}<br>
</c:forEach>
</li>
</ul>

<!-- 배열, 리스트 반복문 -->
<c:forEach var="data" items="${dataList}">
	${data}
</c:forEach>
</body>
</html>