<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<main>
	<div class="inner">
		<h2 class="subTitle">MEMBER INFO</h2>
		<div id="contents">
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 150px">
						<col>
					</colgroup>
					<tbody>
						<tr>
							<th>ID</th>
							<td class="left">${memberDto.id }</td>
						</tr>
						<tr>
							<th>NAME</th>
							<td class="left">${memberDto.name }</td>
						</tr>
						<tr>
							<th>E-MAIL</th>
							<td class="left">${memberDto.email }</td>
						</tr>
						<tr>
							<th>PHONE</th>
							<td class="left">${memberDto.phone }</td>
						</tr>
						<tr>
							<th>ZIP-CODE</th>
							<td class="left">${memberDto.zipCode }</td>
						</tr>
						<tr>
							<th>ADDRESS</th>
							<td class="left">${memberDto.address }</td>
						</tr>
					</tbody>
				</table>
				<div class="btns">
					<a href="Update.do" class="btn btnConfirm">회원정보 수정</a>
					<a href="Delete.do" class="btn btnCancel">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="../include/footer.jsp"%>

