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

String num = request.getParameter("deptno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept</title>
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
			<th class="empno">EMPNO</th>
			<th class="ename">DNAME</th>
			<th class="loc">JOB</th>
			<th class="sal">SAL</th>
		</tr>
		<%
		String sql = "select * from emp where deptno = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			String sal = rs.getString("sal");
		%>
		<tr>
			<td><%=empno%></td>
			<td><%=ename%></td>
			<td><%=job%></td>
			<td><%=sal%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>