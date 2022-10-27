<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인</title>
</head>

<body>
	<form action="result.jsp">
		아이디: <input type="text" size="20" /><br>
		비밀번호: <input type="password" size="20" /><br>
		<input type="submit" value="로그인" /><input type="reset" value="다시 입력" /><br>
		<a href="${contextPath}/views/jstl/core/sign-up.jsp">회원가입</a>
	</form>

</body>

</html>