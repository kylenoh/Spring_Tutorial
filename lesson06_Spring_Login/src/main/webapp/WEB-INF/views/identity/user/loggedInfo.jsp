<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					<td>PW</td>
					<td>
						${member.member_pw}
					</td>
				</tr>
				<tr>
					<td>PW확인</td>
					<td>
						${member.member_pwChk}
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
		
		<a href="/login/portal">메인 페이지 이동</a>
</body>
</html>