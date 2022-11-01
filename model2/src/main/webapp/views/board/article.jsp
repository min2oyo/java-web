<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>글보기</title>
	<style>
		#tr_btn_modify{
			display:none;
		}
	</style>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
</head>

<body>
	<form name="frmArticle" method="post" enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">
					글번호
				</td>
				<td>
					<input type="text" value="${article.articleNO}" disabled />
					<input type="hidden" name="articleNO" value="${article.articleNO}" />	<!-- 4 -->
				</td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">
					작성자 아이디
				</td>
				<td >
					<input type="text" value="${article.id}" name="id" disabled />
				</td>
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">
					제목 
				</td>
				<td>
					<input type="text" value="${article.title}" name="title" id="i_title" disabled />
				</td>   
			</tr>
			<tr>
				<td width="150" align="center" bgcolor="#FF9933">
					내용
				</td>
				<td>
					<textarea rows="20" cols="60" name="content" id="i_content" disabled />${article.content}</textarea>
				</td>  
			</tr>
			<c:if test="${not empty article.imageFileName && article.imageFileName!='null'}">	<!-- imageFileName 값이 있으면 이미지 표시 -->
				<tr>
					<td width="20%" align="center" bgcolor="#FF9933" rowspan="2">
						이미지
					</td>
					<td>
						<input type="hidden" name="originalFileName" value="${article.imageFileName }" />	<!-- 이미지 파일 이름, 이미지 수정에 대비해 미리 원래 이미지 파일 이름을 <hidden>태그에 저장 -->
						<img src="${contextPath}/download?imageFileName=${article.imageFileName}&articleNO=${article.articleNO}" id="preview" /><br>	<!-- FileDownloadController 서블릿에 이미지 파일 이름과 글 번호를 전송해 이미지를 <img> 태그에 표시 -->
					</td>   
				</tr>  
				<tr>
					<td>
						<input type="file" name="imageFileName" id="i_imageFileName" disabled onchange="readURL(this);" />	<!-- 수정된 이미지 파일 이름 전송 -->
					</td>
				</tr>
			</c:if>
			<tr>
				<td width="20%" align="center" bgcolor="#FF9933">
					등록일자
				</td>
				<td>
					<input type=text value="<fmt:formatDate value="${article.writeDate}" />" disabled />
				</td>   
			</tr>
			<tr id="tr_btn_modify">
				<td colspan="2" align="center">
					<input type=button value="수정하기" onClick="fn_modify_article(frmArticle)">
					<input type=button value="취소하기" onClick="backToList(frmArticle)">
				</td>
			</tr>
			<tr id="tr_btn">
				<td colspan=2 align="center">
<%-- 					<c:if test="${member.id == article.id}"> --%>
<!-- 						<input type=button value="수정하기" onClick="fn_enable(this.form)"> -->
<%-- 						<input type=button value="삭제하기" onClick="fn_remove_article('${contextPath}/board/delete', ${article.articleNO})"> --%>
<%-- 					</c:if> --%>
					<input type=button value="수정하기" onClick="fn_enable(this.form)">
					<input type=button value="삭제하기" onClick="fn_remove_article('${contextPath}/board/delete', ${article.articleNO})">
					<input type=button value="리스트로 돌아가기" onClick="backToList(this.form)">
					<input type=button value="답글쓰기" onClick="fn_reply_form('${contextPath}/board/reply', ${article.articleNO})">
				</td>
			</tr>
		</table>
	</form>
 
	<script>
		function backToList(obj) {
			obj.action="${contextPath}/board/list";
			obj.submit();
		}
		
		function fn_enable(obj) {	// 수정하기 클릭시 텍스트 박스 활성화
			document.getElementById("i_title").disabled=false;	// 텍스트 박스의 id로 접근해 disabled 속성을 false로 설정
			document.getElementById("i_content").disabled=false;
			document.getElementById("i_imageFileName").disabled=false;
			document.getElementById("tr_btn_modify").style.display="block";
			document.getElementById("tr_btn").style.display="none";
		}
		
		function fn_modify_article(obj) {	// 수정 반영하기 클릭 시 컨트롤러에 수정 데이터를 전송
			obj.action="${contextPath}/board/update";
			obj.submit();
		}
		
		function fn_remove_article(url,articleNO) {
			let form = document.createElement("form");	// 동적으로 form 태그 생성
			form.setAttribute("method", "post");
			form.setAttribute("action", url);
			
			let articleNOInput = document.createElement("input");	// 동적으로 input 태그 생성한 후 name과 value를 articleNO와 글 번호로 설정
			articleNOInput.setAttribute("type","hidden");
			articleNOInput.setAttribute("name","articleNO");
			articleNOInput.setAttribute("value", articleNO);
			
			form.appendChild(articleNOInput);	// 동적으로 생성된 <input> 태그를 동적으로 생성한 <form> 태그에 append함
			document.body.appendChild(form);	// <form> 태그를 <body> 태그에 추가(append)한 후 서버에 요청
			form.submit();
		}
		
		function readURL(input) {
			if (input.files && input.files[0]) {
				let reader = new FileReader();
				reader.onload = function (e) {
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
			}
		}  
	</script>
</body>

</html>