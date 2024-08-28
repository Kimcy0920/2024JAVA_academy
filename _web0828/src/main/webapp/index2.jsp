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
			<th class="deptno">DEPTNO</th>
			<th class="dname">DNAME</th>
			<th class="loc">LOC</th>
		</tr>
		<%
		String sql = "select * from dept";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String deptno = rs.getString("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
		%>
		<tr>
			<td><a href="javascript:callEmp(<%=deptno%>)"><%=deptno%></a></td>
			<td><%=dname%></td>
			<td><%=loc%></td>
		</tr>
		<%
		}
		%>
	</table>
	<hr>
	<div id="result"></div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		function callEmp(deptno) {
			$.ajax({
				url: "emp.jsp?deptno=" + deptno,
				method: "get",
				success: function(data) {
					$('#result').html(data);
				}
			
			})
		}
	</script>
</body>
</html>