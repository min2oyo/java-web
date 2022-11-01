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
	<title>답글 쓰기</title>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script> 
</head>

<body>
	<h1 style="text-align:center">답글 쓰기</h1>
	<form action="${contextPath}/board/addReply.do" method="post" name="frmReply" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td align="right">글쓴이:&nbsp;</td>
				<td><input type="text" size="5" value="lee" disabled /></td>
			</tr>
			<tr>
				<td align="right">글제목:&nbsp;</td>
				<td><input type="text" size="67" maxlength="100" name="title" /></td>
			</tr>
			<tr>
				<td align="right" valign="top"><br>글내용:&nbsp;</td>
				<td><textarea name="content" rows="10" cols="65" maxlength="4000"></textarea></td>
			</tr>
			<tr>
				<td align="right">이미지파일 첨부: </td>
				<td><input type="file" name="imageFileName" onchange="readURL(this);" /></td>
				<td><img id="preview" src="#" width=200 height=200/></td>
			</tr>
			<tr>
				<td align="right"> </td>
				<td>
				<input type=submit value="답글 반영하기" />
				<input type=button value="취소"onClick="backToList(this.form)" />
				</td>
			</tr>
		</table>
	</form>

	<script>
		function backToList(obj) {
			obj.action="${contextPath}/board/list";
			obj.submit();
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