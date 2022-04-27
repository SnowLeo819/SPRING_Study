<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div class="inner">
		<h2 class="subTitle">WRITE</h2>
		<div id="contents">
			<!-- 데이터 받아서 처리하기....forward방식으로 데이터 보여주기....  -->
			<form method="POST" action="ReplyWriteProcess.do" id="join" class="form">
				<table>
					<colgroup>
						<col style="width: 20%">
						<col style="width: 80%">
					</colgroup>
					<tbody>
						<tr>
							<th>name <span class="required">*</span></th>
							<td><input type="text" name="user_name" id="user_name"
								placeholder="이름를 입력하세요." value="${loggedName }" disabled></td>
						</tr>
						<tr>
							<th>subject <span class="required">*</span></th>
							<td><input type="text" name="user_subject" id="user_subject"
								placeholder="제목을 입력하세요."></td>
						</tr>

						<tr>
							<th>email <span class="required">*</span></th>
							<td><input type="text" name="user_email" id="user_email"
								placeholder="메일을 입력하세요."></td>
						</tr>
						<tr>
							<th>패스워드 <span class="required">*</span></th>
							<td><input type="password" name="user_pw" id="user_pw"
								placeholder="비밀번호를 입력하세요."></td>
						</tr>
						<tr>
							<th>contents<span class="required">*</span></th>
							<td><textarea placeholder="내용을 입력하세요." name="user_contents"
									id="summernote">${boardDto.contents } ↑[원문]↑ </textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="no" value="${boardDto.no }">
				<input type="hidden" name="reGroup" value="${boardDto.reGroup }">
				<input type="hidden" name="reLevel" value="${boardDto.reLevel }">
				<input type="hidden" name="reStep" value="${boardDto.reStep }">
				<div class="btns">
					<button type="submit" class="btn btnConfirm">글쓰기</button>
					<a href="BoardList.do" class="btn btnCancel">취소</a> 
				</div>
			</form>
		</div>
	</div>
</main>
<script>
	//summernote 적용
	$("#summernote").summernote({
		height : 300,
		callbacks : {
			onImageUpload : function(files) {
				uploadImage(files[0],this);
			}
		}
	});
	//queryString  ===>       view.do?img=aaa&text=bbb   (get)
	// form 태그를 이용하는 방법   <form method="GET 또는 POST" action="넘길 페이지"></form>
	// FormData
	function uploadImage(file,editor) {
		const sendData = new FormData();
		sendData.append("uploadFile",file);
		$.ajax({
			url:"SummerNoteFileUpload.do",
			type:"POST",
			data:sendData,
			contentType:false,
			processData:false,
			dataType:"json",
			success:function(data) {
				console.log(data);
				$(editor).summernote("editor.insertImage",data.url);
			},
			error:function(){
				alert("파일 업로드 실패");
			}
		})
	}
</script>
<%@ include file="../include/footer.jsp"%>

