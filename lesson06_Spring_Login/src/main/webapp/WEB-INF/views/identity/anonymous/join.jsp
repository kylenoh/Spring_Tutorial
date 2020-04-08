<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/common.css" />
</head>
<body>
		<h3>회원가입</h3>

		<form action="memberInsert" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td>
						<input name="member_id" placeholder="Id" maxlength="10" autocomplete="off">
					 </td>
				</tr>
				<tr>
					<td>PW</td>
					<td>
						<input name="member_pw" type="password" placeholder="Pw" maxlength="10" autocomplete="off">
					</td>
				</tr>
				<tr>
					<td>PW확인</td>
					<td>
						<input name="member_pwChk" type="password" placeholder="Pw확인" maxlength="10" autocomplete="off">
					</td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>
						<input name="member_name" placeholder="Name" maxlength="10" autocomplete="off">
					</td>
				</tr>
				<tr>
					<td>MAIL</td>
					<td>
						<input name="member_mail" type="text"  placeholder="Mail">
					</td>
				</tr>
	
				<tr>
					<td align="center">
						<input type="submit" value="Join">
						<input type="reset" value="Cancel">
					</td>
				</tr>
			</table>
		</form>
		
		<hr>
		
		<a href="/login/portal">메인 페이지 이동</a>
</body>
</html>