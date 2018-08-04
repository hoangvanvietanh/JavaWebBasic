<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="danhMucServlet?action=insert" method="Post">
		<table border="1">
			<tr>
				<th>Madm</th>
				<th>Tendm</th>
				<th>Action</th>
			</tr>
			<tr >
				<td><input type="text"name="txtmadm"></td>
				<td><input type="text" name="txttendm"></td>
				<td><input type="submit"value="Insert"></td>
			</tr>
		</table>
	</form>
</body>
</html>