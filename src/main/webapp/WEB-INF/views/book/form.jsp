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
	<h1>
		도서 검색
		<button class="btn btn-default full-right" id="advanced-search-btn">확장검색</button>
	</h1>
	<form class="well" id="search-form" method="post" action="search.do">
		<div class="form-group advanced">
			<label class="radio-inline">
				<input type="radio" name="status" value="N"> 판매중
			</label>
			<label class="radio-inline">
				<input type="radio" name="status" value="Y"> 절판
			</label>
		</div>
		<div class="checkbox advanced">
			<label class="checkbox-inline">
				<input type="checkbox" name="categories" value="소설"> 소설
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" name="categories" value="인문"> 인문
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" name="categories" value="외국어"> 외국어
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" name="categories" value="자기개발"> 자기개발
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" name="categories" value="시/에세이"> 시/에세이
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" name="categories" value="경영/경제"> 경영/경제
			</label>
		</div>
		<div class="form-group ">
			<label>제목</label>
			<input type="text" class="form-control" name="title" />
		</div>
		<div class="form-group advanced">
			<label>저자</label>
			<input type="text" class="form-control" name="author" />
		</div>
		<div class="form-group advanced">
			<label>출판사</label>
			<input type="text" class="form-control" name="publisher" />
		</div>
		<div class="form-group advanced">
			<label>최저가격</label>
			<input type="text" class="form-control" name="minPrice" />
		</div>
		<div class="form-group advanced">
			<label>최고가격</label>
			<input type="text" class="form-control" name="maxPrice" />
		</div>
		<div class="text-right">
			<button class="btn btn-primary">검색</button>
		</div>
	</form>
	
	<h3>조회결과</h3>	
	<table class="table" id="book-table">
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
				<th>절판</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>할인율</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>
</body>
<script type="text/javascript">
//확장검색, 간단검색 기능 추가
$(function(){
	$(".advanced").hide();
	
	$("#advanced-search-btn").click(function(){
		var text = $(this).text();
		if(text == '확장검색'){
			$(".advanced").show();
			$(this).text('간단검색');
		} else {
			$(".advanced").hide();
			$(this).text('확장검색');
		}
	});
	//검색 ajax로 한화면에 검색결과 보여주기
	$('#search-form').submit(function(){
		//조회버튼 눌렀을 때 기존 tbody에 있던 내용을 삭제하기 위해 삭제하는 태그empty()사용
		var $tbody = $('#book-table tbody').empty();
		
		$.ajax({
			type:"POST",
			url:"/ajax/search.do",
			dataType:"json",
			data: $('#search-form').serialize(),
			success: function(result){
				var isSuccess = result.success;
				if(isSuccess){
					var books = result.items;
					$.each(books, function(index, book){
						var row = "<tr>";
						row += "<td>"+book.no+"</td>"
						row += "<td>"+book.status+"</td>"
						row += "<td>"+book.mainCategory+"</td>"
						row += "<td>"+book.title+"</td>"
						row += "<td>"+book.author+"</td>"
						row += "<td>"+book.publisher+"</td>"
						row += "<td>"+book.fixedPrice+"</td>"
						row += "<td>"+book.discountRate+"</td>"
						row += "</tr>";
						
						$tbody.append(row);
					});
				} else {
					$tbody.append("<tr><td colspan='8' class='text-center'>조회 결과 없음</td></tr>");
				}
			},
			error: function(){
				console.log('에러');
			}
		});		
		return false; //return값을 false로 두면 버튼을 눌러도 화면이 멈춰있다.
	});
});
</script>
</html>