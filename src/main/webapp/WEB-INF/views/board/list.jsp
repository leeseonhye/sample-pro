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
	<h1>게시글 목록</h1>
	
	<table class="table">
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="10%">
			<col width="10%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${empty boards }">
				<tr>
					<td colspan="5" class="text-center">등록된 글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="board" items="${boards }">
					<tr>
						<td>${board.no }</td>
						<%-- 
							<c:out /> 태그는 EL 표현식보다 안전하기 때문에 사용자가 입력하는 내용은 c:out으로!!
						 --%>
						<td><a href="detail.do?no=${board.no }"><c:out value="${board.title }" /></a></td>
						<td><c:out value="${board.nick }" /></td>
						<td><fmt:formatDate value="${board.createDate }"/></td>
						<td>
							<a href="del.do?no=${board.no }" class="btn btn-danger btn-xs ${board.nick ne LOGIN_USER.id ? 'disabled' : ''}">삭제</a>
							<a href="modify.do?no="${board.no }" class="btn btn-warning btn-xs ${board.nick ne LOGIN_USER.id ? 'disabled' : ''}">수정</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	
	<div class="text-right">
		<a class="btn btn-default" href="form.do">새글</a>
	</div>
</div>

</body>
</html>