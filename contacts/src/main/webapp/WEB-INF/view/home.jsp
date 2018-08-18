<%@page import="com.green.example.model.ContactDetailModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/home.css">
<title>Insert title here</title>
</head>
<body>
	<div id="contrainer">
		<div class ="box">
			<input class="setting" type="image" id="setting" alt="setting"
           	src="resources/images/Settings.png" />
           	
           	<form action="phoneServlet?action=contacts" method="Post">
      		<input class="contacts" type="image" id="contacts" alt="contacts"
      		src="resources/images/contact.png" />
      		</form>
      		
      		<form action="phoneServlet?action=call" method="Post">
       		<input class="call" type="image" id="call" alt="call"
           	src="resources/images/call.png"  />
           	</form>
           	
           	<input class="messages" type="image" id="messages" alt="messages"
           	src="resources/images/messages.png" />
        </div>
	</div>
	<div id="main">
		<%
			ContactDetailModel user = new ContactDetailModel();
		%>
		<c:forEach var='u' items ="<%= user.getList() %>">
		<table class="tbl-border">
		<tr>
			<th>Avatar</th>
			<th>Full Name</th>
			<th>Birthday</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Note</th>
			<th colspan="2">Actions</th>
		<tr>
			<td class="c"><img src="resources/images/${u.photo}" height="100px" width="100px"></td>
			<td class="c">${u.name}</td>
			<td class="c">${u.birthday}</td>
			<td class="c">${u.sex}</td>
			<td class="c">${u.address}</td>
			<td class="c">${u.phoneNumber}</td>
			<td class="c">${u.email}</td>
			<td class="c">${u.note}</td>
			<td>
				<form action="" method="post">
					<input type="hidden" name="action" "/>
					<input type="hidden" name="contactId" "/>
					<button type="submit" >Delete</button>
				</form>
			</td>
		</tr>
		</table>
			</c:forEach>
		</div>
</body>
</html>