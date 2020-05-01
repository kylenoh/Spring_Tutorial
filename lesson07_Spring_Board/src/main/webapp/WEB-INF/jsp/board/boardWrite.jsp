<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<form action="insertBoard">
		<table>
			<colgroup>
				<col width="15%">
				<col width="*" />
			</colgroup>
			<caption>게시글 작성</caption>
			<tbody>
				<tr>
					<th scope="row">제목</th>
					<td><input type="text" id="TITLE" name="TB_TITLE"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="10" cols="50" name="TB_CONTENTS"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
			<button type="submit">작성하기</button>
	</form>
			<a href="callBoardList">목록으로</a>
</body>
</html>

