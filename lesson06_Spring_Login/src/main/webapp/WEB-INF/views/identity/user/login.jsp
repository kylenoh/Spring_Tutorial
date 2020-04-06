<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>로그인</h3>

	<form action="login_form" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td>
	        		<input type="text" name="id" autocomplete="off" placeholder="Id">
	        	</td>
			</tr>
			<tr>
				<td>PW</td>
				<td>
		            <input type="password" name="pass" autocomplete="off" placeholder="Password" onkeypress="if (event.keyCode==13) login()">
				</td>
			</tr>
			<tr>
				<td colspan="2">
		            <button type="submit">Log In</button>
				</td>
			</tr>
		</table>
	</form>
	
	<hr>
		
	<a href="/login/portal">메인 페이지 이동</a>
</body>
</html>