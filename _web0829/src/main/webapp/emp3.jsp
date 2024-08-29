<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String num = request.getParameter("deptno");
//데이터베이스 접속
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
<title>Insert title here</title>
<style>
table {
	width: 680px;
	text-align: center;
}

th {
	background-color: cyan;
}

.num {
	width: 80px;
}

.title {
	width: 230px;
}

.writer {
	width: 100px;
}

.regtime {
	width: 180px;
}

a:link {
	text-decoration: none;
	color: blue;
}

a:visited {
	text-decoration: none;
	color: gray;
}

a:hover {
	text-decoration: none;
	color: red;
}
/* path 속성 바꾸기 */
svg path {
  fill: transparent; 
  stroke: red;
  stroke-width: 1;
}
</style>
</head>
<body>
<ul class="print-data"></ul>
<script>
    let json = null;
    
    const apiUrl = 'http://localhost:3000/posts';
    function readPosts() {
        fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const printData = document.querySelector('.print-data');
            printData.innerHTML = '';
            data.forEach(post => {
                printData.innerHTML += `<li>empno: ${post.empno} <br>ename: ${post.ename} <br>job: ${post.job}</li>`;
            });
            console.log(printData);
        })
        .catch(error => console.error('Error:', error));
    }
    function createPost(obj) {
        console.log(JSON.stringify(obj));
        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Post created:', data);
        })
        .catch(error => console.error('Error:', error));
    }
		<%
		String sql = "SELECT json_object('empno', empno, 'ename', ename, 'job', job, 'sal', sal) FROM emp";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String data = rs.getString(1);
		%>
	json = JSON.parse('<%=data%>');
	createPost(json);

		<%
		}
		%>
	readPosts();

</script>
</body>
</html>