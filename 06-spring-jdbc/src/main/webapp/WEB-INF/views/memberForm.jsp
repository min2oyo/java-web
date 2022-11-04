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
	<title>회원가입</title>
	<style>
		.text_center {
			text-align: center;
		}
	</style>
</head>

<body>
	<form action="${contextPath}/member/addMember.do" method="post">
		<h1 class="text_center">회원가입</h1>
		<table align="center">
			<tr>
				<td width="200" align="right">아이디</td>
				<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="200" align="right">비밀번호</td>
				<td width="400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="200" align="right">이름</td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200" align="right">이메일</td>
				<td width="400"><input type="email" name="email"></td>
			</tr>
			<tr>
				<td width="200" align="right">&nbsp;</td>
				<td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시 입력"></td>
			</tr>
		</table>
	</form>
</body>

</html>