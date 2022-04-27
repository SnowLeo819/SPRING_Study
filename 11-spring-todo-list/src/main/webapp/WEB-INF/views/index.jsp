<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CORONA</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/layout.css" />
<script src="js/gsap/gsap.min.js"></script>
<script src="js/axios.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/main.js" defer></script>
</head>
<body>
	<div class="todo">
		<div class="day" id="pickedDay">Mon</div>
		<div class="date" id="pickedDate">07</div>
		<div class="inputBox">
			<input type="text" name="todoTxt" id="todoTxt" />
			<button class="btnAdd">
				<span class="material-icons">add</span>
			</button>
		</div>
		<div class="todoListBox">
			<ul class="todoList">
				<!-- <li data-no="1" class="done"><span>테스트 Todo</span>
					<button class="btnDelete">
						<span class="material-icons">delete</span>
					</button></li> -->
			</ul>
		</div>
	</div>
	<div class="calendarBox">
		<div class="calendar">
			<div class="header">
				<button class="prev">
					<span class="material-icons">chevron_left</span>
				</button>
				<div class="monthBox">
					<span class="year">2021</span> <span class="month">12</span>
				</div>
				<button class="next">
					<span class="material-icons">chevron_right</span>
				</button>
			</div>
			<!-- header -->
			<div class="days">
				<ul>
					<li class="sun"><span>SUN</span></li>
					<li><span>MON</span></li>
					<li><span>TUE</span></li>
					<li><span>WED</span></li>
					<li><span>THU</span></li>
					<li><span>FRI</span></li>
					<li class="sat"><span>SAT</span></li>
				</ul>
			</div>
			<!-- days -->
			<div class="dates">
				<ul>
					<!-- <li><span>01</span></li>
              <li><span>02</span></li>
              <li><span>03</span></li>
              <li><span>04</span></li>
              <li><span>05</span></li>
              <li><span>06</span></li>
              <li><span>07</span></li> -->
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
