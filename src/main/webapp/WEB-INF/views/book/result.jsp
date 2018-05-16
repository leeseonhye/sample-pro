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
	<h1>검색 결과</h1>
	<table class="table">
		<colgroup>
			<col width="5%" />
			<col width="7%" />
			<col width="10%" />
			<col width="*" />
			<col width="10%" />
			<col width="15%" />
			<col width="7%" />
			<col width="7%" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>절판여부</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>할인율</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty books }">
					<tr>
						<td colspan="8" class="text-center">검색된 도서정보가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="book" items="${books }">
						<tr>
							<td>${book.no }</td>
							<td>${book.status }</td>
							<td>${book.mainCategory }</td>
							<td>${book.title }</td>
							<td>${book.author }</td>
							<td>${book.publisher }</td>
							<td>${book.fixedPrice }</td>
							<td>${book.discountRate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>

</body>
</html>