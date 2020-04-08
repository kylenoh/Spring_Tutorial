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
		<h3>수정 정보 출력</h3>
		<form action="memberModify" method="POST">
			<table>
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="member_id" value="${member.member_id}">
					 </td>
				</tr>
				<tr>
					<td>PW</td>
					<td>
						<input type="text" name="member_pw" value="${member.member_pw}">
					</td>
				</tr>
				<tr>
					<td>PW확인</td>
					<td>
						<input type="text" name="member_pwChk" value="${member.member_pwChk}">
					</td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>
						<input type="text" name="member_name" value="${member.member_name}">
					</td>
				</tr>
				<tr>
					<td>MAIL</td>
					<td>
						<input type="text" name="member_mail" value="${member.member_mail}">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Modify">
					</td>
				</tr>
			</table>
		</form>
		
		<hr>
		
		<a href="/login/portal">메인 페이지 이동</a>	<br>
		<a href="/login/memberDelete">삭제 후 메인 페이지 이동</a>
		
</body>
</html>