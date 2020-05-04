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

		<table border="1" style="border: 1px solid #ccc">
			<colgroup>
				<col width="15%"/>
				<col width="35%"/>
				<col width="15%"/>
				<col width="35%"/>
			</colgroup>
			<caption>게시글 상세</caption>
			<tbody>
				<tr>
					<th scope="row">글 번호</th>
					<td>${map.TB_IDX }</td>
					<th scope="row">조회수</th>
					<td>${map.TB_CONTENT_CNT }</td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td>${map.TB_WRITE_ID }</td>
					<th scope="row">작성시간</th>
					<td>${map.TB_WRITE_DTM }</td>
				</tr>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3">${map.TB_TITLE}</td>
				</tr>
				<tr>
					<td colspan="4">${map.TB_CONTENTS}</td>
				</tr>
			</tbody>
		</table>
	<a href="callBoardList">목록으로</a>
	<a href="callBoardUpdate?TB_IDX=${map.TB_IDX }">수정하기</a>

</body>
</html>