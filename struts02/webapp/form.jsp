<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>입력페이지</h1>
	<form action="ex03.action">
		<div>
			<label for="id">id</label>
			<input type="text" name="id" id="id" />
		</div>
		<div>
			<label for="num">num</label>
			<input type="number" name="num" id="num" />
		</div>
		<div>
			<button type="submit">전달</button>
		</div>
	</form>
</body>
</html>