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

	<h4>게시판 목록</h4>
	<table border="1" style="border: 1px solid #ccc">
		<colgroup>
			<col width="5%" />
			<col width="*" />
			<col width="5%" />
			<col width="30%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">글번호</th>
				<th scope="col">제목</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list }" var="row">
						<tr>
							<td>${row.TB_IDX }</td>
							<td>${row.TB_TITLE }</td>
							<td>${row.TB_CONTENT_CNT }</td>
							<td>
								<fmt:formatDate value="${row.TB_WRITE_DTM }" pattern="yyyy-MM-dd KK:mm:ss"/>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>



</body>
</html>
