<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("utf-8"); %>

<c:set var="score" value="${param.score}" />
<c:choose>
	<c:when test="${score >= 90}">
		<c:set var="grade" value="A" />
	</c:when>
	<c:when test="${score >= 80}">
		<c:set var="grade" value="B" />
	</c:when>
	<c:when test="${score >= 70}">
		<c:set var="grade" value="C" />
	</c:when>
	<c:when test="${score >= 60}">
		<c:set var="grade" value="D" />
	</c:when>
	<c:otherwise>
		<c:set var="grade" value="F" />
	</c:otherwise>
</c:choose>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>학점 계산</title>
</head>

<body>
	<h1>시험 점수를 입력해주세요</h1>
	<form action="score.jsp">
		시험 점수: <input type="number" name="score" /><br>
		<input type="submit" value="변환" /><a href="score.jsp?"><button>다시 하기</button></a>
	</form>
	<c:if test="${not empty score}">
		<c:if test="${score >= 0 && score <= 100}">
			<h1>시험 점수: ${score}점</h1>
			<h1>${grade}학점입니다</h1>
		</c:if>
		<c:if test="${not (score >= 0 && score <= 100)}">
			<h2>점수를 잘못 입력했습니다. 다시 입력하세요</h2>
		</c:if>
	</c:if>
</body>

</html>