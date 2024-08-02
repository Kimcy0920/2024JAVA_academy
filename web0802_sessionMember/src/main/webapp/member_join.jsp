<%@page import="member.memberDTO"%>
<%@page import="member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%

request.setCharacterEncoding("utf-8");
// Statement stmt = conn.createStatement();
        
        // 이미 존재하는 아이디인지 체크하는 쿼리
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        if (id.equals("id")) {   
            // 이미 있는 아이디이면 오류 표시
%>
            <script>
                alert('이미 등록된 아이디입니다.');
                history.back()
            </script>
<%          
        } else {
        	memberDAO dao = new memberDAO();
        	memberDTO dto = new memberDTO(id, pw, name);
        	dao.insertMember(dto);            
%>

            <script>
                alert('가입이 완료되었습니다.');
                window.close();
            </script>
<%
        }
%>
</body>
</html>