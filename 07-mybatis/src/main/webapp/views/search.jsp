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
	<title>회원 검색</title>
</head>

<body>
	<!-- 검색할 값 -->
	<form action="${pageContext.request.contextPath}/member">
		입력 : <input type="text" name="value" />
		
		<!-- 검색 조건 -->
		<select name="action">
			<option value="listMembers">전체</option>
			<option value="selectMemberById">아이디</option>
			<option value="selectMemberByPwd">비밀번호</option>
		</select><br>
		
		<input type="submit" value="검색" />
	</form>
</body>

</html>