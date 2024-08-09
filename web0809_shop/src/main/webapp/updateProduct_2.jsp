<%@page import="shop.ProductDTO"%>
<%@page import="shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String name = request.getParameter("name");
String description = request.getParameter("description");
String price = request.getParameter("price");
String stock = request.getParameter("stock");
ProductDAO productDAO = new ProductDAO();
ProductDTO product = new ProductDTO(Integer.parseInt(id),
						 name, description, Double.parseDouble(price),
						 Integer.parseInt(stock));
productDAO.updateProduct(product);
%>
<jsp:forward page="products.jsp"/>