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
	 <ul>
		<li><a href="ParameterObject01.do?data01=10&data02=20&data03=30&data03=40">데이터 보내깅ㅇ object01</a> </li> 
		<li><a href="ParameterObject02.do?data01=10&data02=20&data03=30&data03=40">데이터 보내깅ㅇ object02</a> </li> 
	 </ul>
	
	<hr>

	<form action="ParameterObject03.do" method="get">
		<legend>Member</legend>
		<div><label><span>no</span><input type="text" name="no"></label></div>
		<div><label><span>id</span><input type="text" name="id"></label></div>
		<div><label><span>name</span><input type="text" name="name"></label></div>
		<div><label><span>password</span><input type="text" name="password"></label></div>
		<button>Object03.do 로 보내기</button>
	</form>
	
	<hr>
	
	<form action="ParameterObject04.do" method="POST">
		<legend>Member</legend>
		<div><label><span>no</span><input type="text" name="no"></label></div>
		<div><label><span>id</span><input type="text" name="subject"></label></div>
		<div><label><span>password</span><input type="text" name="password"></label></div>
		<button>Object04.do 로 보내기</button>
	</form>
	
	
	
</body>
</html>