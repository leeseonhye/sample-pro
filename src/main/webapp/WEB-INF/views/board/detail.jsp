<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h1>게시글 정보</h1>
	
	<table class="table">
		<tbody>
			<tr>
				<th>번호</th>
				<td>${board.no }</td>
				<th>등록일</th>
				<td><fmt:formatDate value="${board.createDate }"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><c:out value="${board.title }" /></td>
				<th>추천수</th>
				<td><fmt:formatNumber value="${board.likes }"/> </td>
			</tr>
			<tr>
				<th>첨부파일</th>
					<td>
						<c:choose>
							<c:when test="${not empty board.filename }">
								${board.filename } <a href="down.do?no=${board.no }" class="btn btn-default btn-xs">다운로드</a>
							</c:when>
							<c:otherwise>
								없음
							</c:otherwise>
						</c:choose>			
					</td>
				<th>닉네임</th>
				<th>${board.nick }</th>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><c:out value="${board.contents }" /></td>
			</tr>
		</tbody>
	</table>
	<div class="text-right">
		<a href="like.do?no=${board.no }" class="btn btn-default ${board.nick eq LOGIN_USER.id ? 'disabled' : ''}">추천</a>
		<a href="list.do" class="btn btn-primary">목록</a>
	</div>
</div>
</body>
</html>