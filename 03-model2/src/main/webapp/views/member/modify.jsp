<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 수정</title>
	<style>
		.cls1 {
			font-size:40px;
			text-align:center;
		}
	</style>
</head>

<body>
	<h1 class="cls1">회원 수정</h1>
	<form method="post" action="${contextPath}/model2/member/update?id=${member.id}">
		<table align="center" >
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><input type="text" name="id" value="${member.id}" disabled></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</td>
				<td width="400"><input type="password" name="pwd" value="${member.pwd}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</td>
				<td width="400"><input type="text" name="name" value="${member.name}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</td>
				<td width="400"><input type="text" name="email" value="${member.email}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">가입일</td>
				<td width="400"><input type="text" name="joinDate" value="${member.joinDate}" disabled></td>
			</tr>
				<tr align="center">
				<td colspan="2" width="400"><input type="submit" value="수정하기">
				<input type="reset" value="다시 입력"></td>
			</tr>				
		</table>
	</form>
</body>

</html>