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
	
			<table>
				<tr>
					<td>ID</td>
					<td>
						${sessionMember.member_id}
					 </td>
				</tr>
				<tr>
					<td>NAME</td>
					<td>
						${sessionMember.member_name}
					</td>
				</tr>
				<tr>
					<td>MAIL</td>
					<td>
						${sessionMember.member_mail}
					</td>
				</tr>
			</table>
		
		<P>  The time on the server is ${serverTime}. </P>
		
		<hr>
		
		<a href="/login/portal">메인 페이지 이동</a>	<br>
		
		
</body>
</html>