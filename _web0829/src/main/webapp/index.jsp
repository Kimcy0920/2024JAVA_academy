<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String URL = "jdbc:mysql://localhost:3307/spring5fs";
Connection conn = null;
PreparedStatement pstmt = null;
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection(URL, "root", "mysql");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	width: 680px;
	text-align: center;
	border: ridge;
	background-color: gray;
}

th {
	background-color: gray;
}

td {
	border: 1px solid gray;
	background-color: white;
}

.deptno {
	width: 80px;
}

.dname {
	width: 230px;
}

.loc {
	width: 100px;
}

a:hover {
	text-decoration: none;
	color: red;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th class="json">JSON</th>
		</tr>
		<%
		String sql = "select json_object('empno', empno, 'ename', ename, 'job', job, 'sal', sal) from emp;";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String data = rs.getString(1);
		%>
		<tr>
			<td><%=data%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>