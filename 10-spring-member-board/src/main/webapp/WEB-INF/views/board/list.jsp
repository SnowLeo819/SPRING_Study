<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div class="inner">
		<h2 class="subTitle">BOARD LIST</h2>
		<div id="contents">
			<div class="tableBox">
				<c:choose>
					<c:when test="${!empty loggedId }">
						<div class="btns" style="justify-content: right; margin-bottom:10px">
							<a href="Write.do" class="btn btnConfirm" style="height:40px" id="NewWrite">글쓰기</a>
						</div>
					</c:when>
				</c:choose>
				<table>
					<colgroup>
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 100px">
						<col>
						<col style="width: 200px">
						<col style="width: 200px">
						<col style="width: 50px">
					</colgroup>
					<thead>
						<tr>
							<th>in.NO</th>
							<th>re.NO</th>
							<th>NAME</th>
							<th>SUBJECT</th>
							<th>EMAIL</th>
							<th>DATE</th>
							<th>HIT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList }" var="boardDto" varStatus="loop">
							<tr>
								<td></td>
								<td>${boardDto.no }</td>
								<td>${boardDto.name }</td>
								<td class="space${boardDto.reStep } left" style="padding:0 20px"><c:if
										test="${boardDto.reStep > 1 }">
										<span class="material-icons">subdirectory_arrow_right</span>
									</c:if> <a href="View.do?no=${boardDto.no }">${boardDto.subject }</a>
								</td>
								<td>${boardDto.email }</td>
								<td>${boardDto.regDate }</td>
								<td>${boardDto.hit }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pagination">
					<ul>
						<!-- 
						<li><a href="BoardList.do?start=1&end=5">1</a></li>						
						<li><a href="BoardList.do?start=6&end=10">2</a></li>						
						<li><a href="BoardList.do?start=11&end=15">3</a></li>						
						<li><a href="BoardList.do?start=16&end=20">4</a></li> 
						-->
						<c:if test="${startPage != 1 }">
							<li><a href="BoardList.do?clickPage=${startPage-pageBlock }"><span class="material-icons"> chevron_left </span></a></li>
						</c:if>
						<c:forEach var="page" begin="${startPage }" end="${endPage }"
							step="1" varStatus="loop">
							<li class=${clickPage==page?'active':'' }><a href="BoardList.do?clickPage=${page }">${page }</a></li>
						</c:forEach>
						<c:if test="${endPage != lastPage }">
							<li><a href="BoardList.do?clickPage=${startPage+pageBlock }"><span class="material-icons"> chevron_right </span></a></li>
						</c:if>
					</ul>
				</div>
				<form action="BoardSearchList.do" class="from" method="get">
					<div class="searchBox">
						<select name="search_select">
							<option value="subject" selected>제목</option>
							<option value="name">작성자</option>
							<option value="contents">내용</option>
						</select> <input type="text" placeholder="검색할 내용을 입력해주세요"
							name="search_word">
						<button class="btn btnBlack">검색</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>

<script>
// 	consol.log(${not empty loggedMember});
// 	$("#NewWrite").on("click",function(){
// 		if(!empty loggedMember){
// 		}
// 	})
</script>

<%@ include file="../include/footer.jsp"%>

