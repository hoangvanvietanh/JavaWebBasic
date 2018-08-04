
<%@page import="entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css" media="all">
	#main
		{
			width: 100%;
			height: 100%;
			background-color: white;
			float: left;
			margin: 6px;
			text-align: center;
			text-align: justify;
		}
	#column1
		{
			padding-top: 8px;
			width: 250px;
			height: 250px;
			background-color: #FEE1FE;
			float: left;
			margin: 8px;
			text-align: center;
		}
		#cart
		{
			width: 300px;
			height: 50px;
			background-color: #FEE1FE;
			margin: 2px;
			text-align: center;
		}
</style>

</head>
<body>
	<table>
		<tr>
			<td>Tai khoan <input type="text"name="txttaikhoan"> </td>
			<td>Mat khau <input type="text"name="txtmatkhau"></td>
			<td><input type="submit"value="Login"></td>
		</tr>
	</table>
	<div border="1" id="main">
		<% ProductModel promodel = new ProductModel(); %>
		
		<c:forEach var="p" items="<%= promodel.getList() %>">
		<div id="column1">
			<div>${p.madm} ${p.msp}</div><br/>
			<div><img src="resources/images/${p.hinh}" height="120px" width="160px"></div><br/>
			<div>${p.tensp}</div>
			<div>${p.gia}</div>
			<div><a href="CartServlet?action=add&masp=${p.msp}">Add Cart</a></div>
		</div>
		
		</c:forEach>
	</div>
</body>
</html>