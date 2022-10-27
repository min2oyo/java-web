<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인 결과</title>
</head>

<body>
	<c:if test="${empty param.userId}">
		아이디를 입력하세요<br>
		<a href="login.jsp">로그인 하기</a>
	</c:if>
	<c:if test="${param.userId.equals('admin')}">
		<h1>관리자로 로그인했습니다</h1>
		<form>
			<input type="button" value="회원정보 수정" />
			<input type="button" value="회원정보 삭제" />
		</form>
	</c:if>
	<c:if test="${not empty param.userId}">
		<h1>환영합니다. ${param.userId}님!</h1>
<%-- 		<h1>비밀번호: <%= userPw %></h1> --%>
	</c:if>
</body>

</html>