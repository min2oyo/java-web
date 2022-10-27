<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="memberVO" class="member.MemberVO" />
<jsp:useBean id="memberDAO" class="member.MemberDAO" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 목록</title>
</head>

<body>
	<h2 align="center">회원 목록</h2>
	<div align="right"><a href="sing-up.jsp"><button>회원가입</button></a></div>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
		<c:choose>
			<c:when test="${membersList == null}">
				<tr>
					<td colspan="5">
						<p align="center">
							<b><span style="font-size: 9pt;">등록된 회원이 없습니다.</span></b>
						</p>
					</td>
				</tr>
			</c:when>
			<c:when test="${membersList != null}">
			  <c:forEach var="member" items="${membersList}">
					<tr align="center">
						<td>${member.id}</td>
						<td>${member.pwd}</td>
						<td>${member.name}</td>
						<td>${member.email}</td>
						<td>${member.joinDate}</td>
					</tr>
					<tr height="1" bgcolor="#99ccff">
						<td colspan="5"></td>
					</tr>
			   </c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>

</html>