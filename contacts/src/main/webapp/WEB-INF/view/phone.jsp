<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/phone.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="relative">
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
	
</body>
</html>