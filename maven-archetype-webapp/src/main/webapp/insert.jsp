<%@page import="com.sun.org.apache.bcel.internal.generic.ACONST_NULL"%>
<%@page import="model.Danhmucmodel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form enctype="multipart/form-data" action="ProductServlet?action=insert" method="Post">
		<table border="1">
			<tr>
				<th>Madm</th>
				<th>MaSp</th>
				<th>TenSP</th>
				<th>Gia</th>
				<th>Hinh</th>
				<th>Action</th>
			</tr>
			<tr >
				<td>
					<%ArrayList list = new Danhmucmodel().getList(); %>
					<select name="txtmadm">
						<c:forEach var="dm" items="<%=list %>">
							<option value="${dm.madm}"${dm.tendm==param.madm?'selected':''}>${dm.madm}</option>
						</c:forEach>						
					</select>
				</td>
				<td><input type="text"name="txtmsp"></td>
				<td><input type="text"name="txttensp"></td>
				<td><input type="text"name="txtgia"></td>
				<td><input type="file" name="file"></td>
				<td><input type="submit"value="Insert"></td>
			</tr>
		</table>
	</form>
</body>
</html>