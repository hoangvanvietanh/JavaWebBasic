<%@page import="com.sun.org.apache.bcel.internal.generic.ACONST_NULL"%>
<%@page import="entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css" media="all">
html,body{
	height:100%;
	margin:0;
	padding:0;
}
body{
	text-align:center;
	min-width:600px;
	min-height:400px;
}

div#vertical {
	float: left;
	height:50%;
	margin-top:-200px;
	width:100%;
}

table#content {
	margin: 0 auto;
	width: 600px;
    background: #eee;
	height: 400px;
	clear: both;
	overflow: auto;
}

</style>

</head>
<body>
	View Page
	<div id="vertical"></div>
	<table border="1" id="content">
		<tr>
			<th>Madm</th>
			<th>MaSp</th>
			<th>TenSP</th>
			<th>Gia</th>
			<th>Hinh</th>
			<th>Action</th>
		</tr>
		<% ProductModel promodel = new ProductModel(); %>
		
		<c:forEach var="p" items="<%= promodel.getList() %>">
		<tr>
			<td>${p.madm}</td>
			<td>${p.msp}</td>
			<td>${p.tensp}</td>
			<td>${p.gia}</td>
			<td><img src="images/${p.hinh}" height="150px" width="120px"></td>
			<td><a href="ProductServlet?masp=${p.msp}">Update</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>