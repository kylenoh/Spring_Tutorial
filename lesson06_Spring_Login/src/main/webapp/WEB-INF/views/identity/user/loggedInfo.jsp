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
	<h3>로그인 정보 출력</h3>
	
			<h3>회원가입정보</h3>

			<table>
				<tr>
					<td>ID</td>
					<td>
						${member.member_id}
					 </td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>
						${member.member_name}
					</td>
				</tr>
				<tr>
					<td>MAIL</td>
					<td>
						${member.member_mail}
					</td>
				</tr>
			</table>
		
		<hr>
		
		<a href="/login/portal">메인 페이지 이동</a>	<br>
		<a href="/login/callUpdate">수정 페이지 이동</a>	<br>
		<a href="/login/logout">로그 아웃</a>	<br>
		
</body>
</html>