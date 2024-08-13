<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "";
	String description = "";
	String price = "";
	String stock = "";
	
	ProductDAO pdao = new ProductDAO();
%>
<jsp:forward page="products.jsp"/>