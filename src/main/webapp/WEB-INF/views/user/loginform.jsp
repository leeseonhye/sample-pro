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
	<h1>로그인 폼</h1>
	<!-- param(주소줄에)에  err eq 'fail'이 포함되어 있으면 에러메시지 출력  -->
	<c:if test="${param.err eq 'fail' }">
		<div class="alert alert-danger">
			<strong>오류</strong> 아이디 혹은 비밀번호가 올바르지 않습니다.
		</div>
	</c:if>
	<c:if test="${param.err eq 'deny' }">
		<div class="alert alert-danger">
			<strong>오류</strong> 로그인이 필요한 서비스입니다.
		</div>
	</c:if>

	<form class="well" method="post" action="login.do">
		<div class="form-group">
			<label>아이디</label>
			<input type="text" class="form-control" name="id" />
		</div>
		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" class="form-control" name="pwd" />
		</div>
		<div class="text-right">
			<button class="btn btn-primary">로그인</button>
		</div>
	</form>
</div>
</body>
</html>