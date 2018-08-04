<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>View cart!</h1>
	<form action="CartServlet" method="post">
		<%ArrayList<Item> cart = (ArrayList<Item>)request.getAttribute("list"); %>
		<table border="1" id="content">
			<tr>
				<th>MaSp</th>
				<th>TenSP</th>
				<th>HinhSP</th>
				<th>Gia</th>
				<th>SoLuong</th>
				<td>Total</td>
				<td>Action</td>
			</tr>
			<c:forEach var="i" items="<%=cart %>">
			<tr>
				<td>${i.sanpham.msp}</td>
				<td>${i.sanpham.tensp}</td>
				<td><img src="images/${i.sanpham.hinh}" height="80px" width="60px"></td>
				<td>${i.sanpham.gia}</td>
				<td>${i.soluong}</td>
				<td>${i.sanpham.gia*i.soluong}</td>
				<td><a href="CartServlet?action=delete&masp=${i.sanpham.msp}">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
		<p><b>Total :<%=request.getAttribute("totalcart") %></b> Dong</p>
			<a href="CartServlet?action=removeall">Xoa gio hang</a> |
			<a href="index.jsp">Tiep tuc mua</a> |
			<input type="submit" value="Mua hang">
	</form>
	
</body>
</html>