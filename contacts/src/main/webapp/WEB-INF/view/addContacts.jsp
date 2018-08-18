
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<style type="text/css">
		#testdiv
		{
			width: 250px;
			height: 300px;
			background-color: #FEE1FE;
			float: left;
			margin: 6px;
			text-align: center;
		}
		td.c 
		{
    		text-align: left;
		} 
	</style>
</head>
<body>
	<div id="testdiv">
		<form enctype="multipart/form-data" action="userServlet?action=insert" method="Post">
		<table>
			<tr>
				<td>Name</td>
				<td class="c"><input type="text" name="name" placeholder="Input your last name" ></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td class="c"><input type="file"name="file"></td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td class="c"><input type="date"name="birthday" placeholder="Input your birthday" ></td>
			</tr>
			<tr>
				<td>Sex</td>
				<td class="c"><input type="radio" name="gender" value="male"> Male
				<input type="radio" name="gender" value="female"> Female</td>
			</tr>
			<tr>
				<td>Address</td>
				<td class="c"><input type="text" name="address" placeholder="Input your address" ></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td class="c"><input type="text" name="phone" placeholder="Input your phone number" ></td>
			</tr>
			<tr>
				<td>Email</td>
				<td class="c"><input type="text" name="email" placeholder="Input your email" ></td>
			</tr>
			<tr>
				<td>Note</td>
				<td class="c"><input type="text" name="note" ></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" name="submit">Submit</button>
					<button type="button" name="button">Cancel</button></td>
			</tr>
			
		</table>	
	</form>
	</div>
</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#test").validate({
				rules:
				{
					name: "required",
					sdt: "required",
					email: "required",
				},
				messages:
				{
					name: "Check your last name,please!!!",
					sdt: "Check your phone number,please!!!",
					email: "Check your email,please!!!"
				}
			});
			$("#test").submit(function(){
				if($("#test").validate().form())
				{
					aldert("Form ok");
					return true;
				}
				else
				{
					aldert("Something wrong");
					return false;
				}
			});
			
		});
	</script>
</body>
</html>