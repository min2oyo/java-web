<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:choose>
	<c:when test='${msg == "addMember"}'>
		<script>
			window.onload = function() {
				alert("회원을 등록했습니다.");
			}
		</script>
	</c:when>
	<c:when test='${msg == "modified"}'>
		<script>
			window.onload = function() {
				alert("회원 정보를 수정했습니다.");
			}
		</script>
	</c:when>
	<c:when test='${msg == "deleted"}'>
		<script>
			window.onload = function() {
				alert("회원 정보를 삭제했습니다.");
			} 
		</script>
	</c:when>
</c:choose>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 정보</title>
	<style>
		.cls1 {
				font-size:40px;
				text-align:center;
			}
		.cls2 {
			font-size:20px;
			text-align:center;
		}
	</style>
</head>

<body>
	<p class="cls1">회원 정보</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<th width="7%">아이디</th>
			<th width="7%">비밀번호</th>
			<th width="7%">이름</th>
			<th width="7%">이메일</th>
			<th width="7%">가입일</th>
      <th width="7%">수정</th>
		 	<th width="7%">삭제</th>
		</tr>
		<c:choose>
			<c:when test="${empty membersList}">
				<tr>
					<td colspan=5 align="center">
						<b>등록된 회원이 없습니다.</b>
					</td>  
				</tr>
			</c:when>  
			<c:when test="${!empty membersList}">
				<c:forEach var="member" items="${membersList}">
					<tr align="center">
						<td>${member.id}</td>
						<td>${member.pwd}</td>
						<td>${member.name}</td>     
						<td>${member.email}</td>     
						<td>${member.joinDate}</td>
						<td><a href="${contextPath}/member/modify?id=${member.id}">수정</a></td>
						<td><a href="${contextPath}/member/delete?id=${member.id}">삭제</a></td>  
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>  
	<p class="cls2"><a href="${contextPath}/member/sign-up">회원가입</a></p>
</body>

</html>