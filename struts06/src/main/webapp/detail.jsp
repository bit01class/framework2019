<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css" integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
		$(function(){
			$('form button').hide();
			$('form').next('button').click(function(){
				$('form button').show();
				$('form').next().hide().next().hide();
			});
		});
	
	</script>
</head>
<body>

<div class="jumbotron">
  <h1>상세페이지</h1>
  <p></p>
</div>
<form action="update.bit">
	<div class="form-group">
	  <label for="num">글번호</label>
	  <input type="text" value="${bean.num }" class="form-control" name="num" id="num" readonly="readonly"/>
	</div>
	<div class="form-group">
	  <label for="nalja">날짜</label>
	  <input type="text" value=" ${bean.nalja }" class="form-control" name="nalja" id="nalja" disabled="disabled"/>
	</div>
	<div class="form-group">
	  <label for="sub">제목</label>${FieldErrors.sub }
	  <input type="text" value="${bean.sub }" class="form-control" name="sub" id="sub" placeholder="제목을 입력">
	</div>
	<div class="form-group">
	  <label for="name">글쓴이</label>${FieldErrors.name }
	  <input type="text" value="${bean.name }" class="form-control" name="name" id="name" placeholder="이름을 입력">
	</div>
	<div class="form-group">
		<textarea class="form-control" name="content">${bean.content }</textarea>
	</div>
	<button type="submit" class="btn btn-primary">수정</button>
	<button type="reset" class="btn btn-default">취소</button>
</form>
	<button type="button" class="btn btn-primary">수정</button>
	<a href="delete.bit?idx=${bean.num }" role="button" class="btn btn-danger">삭제</a>
</body>
</html>






















