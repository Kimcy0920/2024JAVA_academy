<%@page import="com.board.db.BoardDao"%>
<%@page import="com.board.db.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String num = request.getParameter("num");
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String content = request.getParameter("content");

BoardDao dao = new BoardDao();
BoardDto dto = new BoardDto(Integer.parseInt(num), writer, title, content, "", 0);
dao.updateOne(dto);
response.sendRedirect("list.jsp");
%>