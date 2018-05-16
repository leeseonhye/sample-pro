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
	<form id="f" class="well" method="post" action="add.do" enctype="multipart/form-data">
		<div class="form-group has-feedback">
			<label class="contorl-label">제목</label>
			<input type="text" class="form-control" name="title" />
			<span class="glyphicon glyphicon-remove form-control-feedback" style="display:none;"></span>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" class="form-control" name="upfile" />
		</div>
		<div class="form-group has-feedback">
			<label class="contorl-label">내용</label>
			<textarea rows="4" class="form-control" name="contents"></textarea>
			<span class="glyphicon glyphicon-remove form-control-feedback" style="display:none;"></span>
		</div>
		<div class="text-right">
			<button class="btn btn-primary">등록</button>
		</div>
	</form>
</div>
<script type="text/javascript">
$(function(){
	$('#f').submit(function(){
		var hasError = false;
		if($(":input[name=title]").val().trim() == ""){
			$(":input[name=title]").parents('.form-group').addClass('has-error')
									.find('span').show();
			hasError = true;
		}
		if($(":input[name=contents]").val().trim() == ""){
			$(":input[name=contents]").parents('.form-group').addClass('has-error')
									.find('span').show();
			hasError = true;
		}
		return !hasError;
	});
});
</script>
</body>
</html>