<%@page import="shop.ProductDTO"%>
<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	String id = request.getParameter("id");
	ProductDAO pdao = new ProductDAO();
	ProductDTO pdto = pdao.getOneProduct(Integer.parseInt(id));
	request.setAttribute("pdto", pdto);
%>
<jsp:forward page="updateProduct_1.jsp"/>