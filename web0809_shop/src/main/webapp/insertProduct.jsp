<%@page import="shop.ProductDAO"%>
<%@page import="shop.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String description = request.getParameter("description");
String price = request.getParameter("price");
String stock = request.getParameter("stock");
ProductDTO product = new ProductDTO(0, name, description, Double.parseDouble(price), Integer.parseInt(stock));
ProductDAO productDAO = new ProductDAO();
productDAO.addProduct(product);
%>
<jsp:forward page="products.jsp"/>
