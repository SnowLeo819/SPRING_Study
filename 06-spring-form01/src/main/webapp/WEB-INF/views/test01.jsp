<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	div {margin-bottom: 50px}
	form label span {display: inline-block;; margin: 0 20px, width:80px}
	form div {margin-bottom: 10px}
</style>

<body>
	<h1>Form TEST</h1>
	<div>
		<form action="Result.do" method="POST">
			<div><label><span>NO. </span><input type="text" name="no" value="${memberDto.no }"></label> </div>
			<div><label><span>name : </span><input type="text" name="name" value="${memberDto.name }"></label> </div>
			<div><label><span>id : </span><input type="text" name="id" value="${memberDto.id }"></label> </div>
			<div><label><span>pw : </span><input type="text" name="password" value="${memberDto.password }"></label> </div>
			<button>전송</button>		
		</form>
	</div>
	
</body>
</html>