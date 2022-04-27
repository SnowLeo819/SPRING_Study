<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INSERT</title>
<link rel="stylesheet" href="css/reset.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=PT+Serif:wght@400;700&family=Raleway:wght@100;200;300;400;500;600;700;800;900&family=Titillium+Web:wght@200;300;400;600;700;900&display=swap"
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<link href="summernote/summernote.min.css" rel="stylesheet" />
<link href="css/fancybox.css" rel="stylesheet" />
<link rel="stylesheet" href="css/layout.css" />
<link rel="stylesheet" href="css/form.css" />
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/fancybox.umd.js"></script>
<script src="js/imagesloaded.pkgd.min.js"></script>
<script src="js/isotope.pkgd.min.js"></script>
<script src="js/main.js" defer></script>
</head>
<body>
	<header id="header">
		<div class="inner"><h1>GALLERY</h1></div>
	</header>
	<div id="filter">
		<ul>
			<li data-filter="item" class="on">ALL</li>
			<li data-filter="travel">TRAVEL</li>
			<li data-filter="movie">MOVIE</li>
			<li data-filter="study">STUDY</li>
			<li data-filter="life">LIFE</li>
		</ul>
	</div>
	<div id="list">
		<ul></ul>
	</div>
	<div class="btns" id="insertBtns">
		<a href="Insert.do" class="btn btnConfirm">글쓰기</a>
	</div>
</body>
</html>



