<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");

	String id = (String) request.getAttribute("id");
	String pwd = (String) request.getAttribute("pwd");
	String name = (String) session.getAttribute("name");
	String email = (String) application.getAttribute("email");
	session.setAttribute("address", "수원시 팔달구");	// 중복, 우선순위 2
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 정보</title>
</head>

<body>
	<h2 align="center">회원 정보</h2>
	<table align="center">
		<tr align="center" bgcolor="#99ccff">
			<td width="10%">종류</td>
			<td width="10%">아이디</td>
			<td width="10%">비밀번호</td>
			<td width="10%">이름</td>
			<td width="10%">이메일</td>
			<td width="10%">주소</td>
		</tr>
		<tr align="center">
			<td>내장 객체</td>
			<td>${id}</td>
			<td>${pwd}</td>
			<td>${name}</td>
			<td>${email}</td>
			<td>${address}</td>
		</tr>
		<tr align="center">
			<td>MemberVO</td>
			<td>${memberVO.id}</td>
			<td>${memberVO.pwd}</td>
			<td>${memberVO.name}</td>
			<td>${memberVO.email}</td>
			<td>(없음)</td>
		</tr>
		<tr align="center">
			<td>ArrayList</td>
			<td>${membersList[0].id}</td>
			<td>${membersList[0].pwd}</td>
			<td>${membersList[0].name}</td>
			<td>${membersList[0].email}</td>
			<td>(없음)</td>
		</tr>
	</table>
</body>

</html>