<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.ACONST_NULL"%>
<%@page import="model.Danhmucmodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form enctype="multipart/form-data" action="ProductServlet?action=update" method="post">
		<%ArrayList<Item> cart = (ArrayList<Item>)request.getAttribute("list"); %>
		<table border="1" id="content">
			<tr>
				<th>Madm</th>
				<th>MaSp</th>
				<th>TenSP</th>
				<th>Gia</th>
				<th>Hinh</th>
			</tr>
			<c:forEach var="i" items="<%=cart %>">
			<tr>
				<td>
					${i.sanpham.madm}<br/>
					<%ArrayList list = new Danhmucmodel().getList(); %>
					<select name="txtmadm">
						<c:forEach var="dm" items="<%=list %>">
							<option value="${dm.madm}"${dm.tendm==param.madm?'selected':''}>${dm.madm}</option>
						</c:forEach>						
					</select>
					
				</td>
				<td><input type="text" name ="txtmsp" value ="${i.sanpham.msp}"></td>
				<td><input type="text" name="txttensp" value ="${i.sanpham.tensp}"></td>
				<td><input type="text" name="txtgia" value ="${i.sanpham.gia}"></td>
				<td>
					<img src="images/${i.sanpham.hinh}" height="80px" width="60px"><br/>
					<input type="hidden" name="txthinh" value="${i.sanpham.hinh}">
					<input type="file" name="file">
				</td>
				
				
			</tr>
			</c:forEach>
		</table>
			<a href="update.jsp">Chon san pham</a> |
			<input type="submit" value="Hoan tat">
			
	</form>
	
</body>
</html>