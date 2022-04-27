<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JAVA로 만든 index PAGE</h1>
	
	<hr>
	
	<form action="Test01.do" method="post">
		<div><label><span>data01</span> <input type="text" name="data01"></label></div>
		<div><label><span>data02</span> <input type="text" name="data02"></label></div>
		<button>Test01.do 로 전송</button>
	</form>
	
	<form action="MemberTest.do" method="post">
		<div><label><span>no</span> <input type="text" name="no"></label></div>
		<div><label><span>id</span> <input type="text" name="id"></label></div>
		<div><label><span>name</span> <input type="text" name="name"></label></div>
		<div><label><span>password</span> <input type="text" name="password"></label></div>
		<button>MemberTest.do 로 전송</button>
	</form>
		
	<form action="MemberTest02.do" method="post">
		<div><label><span>no</span> <input type="text" name="no"></label></div>
		<div><label><span>id</span> <input type="text" name="id"></label></div>
		<div><label><span>name</span> <input type="text" name="name"></label></div>
		<div><label><span>password</span> <input type="text" name="password"></label></div>
		<button>MemberTest02.do 로 전송</button>
	</form>
		
	<form action="BoardTest.do" method="post">
		<div><label><span>no</span> <input type="text" name="no"></label></div>
		<div><label><span>subject</span> <input type="text" name="subject"></label></div>
		<div><label><span>regDate</span> <input type="text" name="regDate"></label></div>
		<div><label><span>password</span> <input type="text" name="password"></label></div>
		<button>BoardTest.do 로 전송</button>
	</form>
	
</body>
</html>