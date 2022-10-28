<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="file1" value="${param.param1}" />	<!-- 다운로드할 파일 이름을 가져옴 -->
<c:set var="file2" value="${param.param2}" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>이미지 파일 출력</title>
</head>

<body>
	파라미터 1: <c:out value="${file1}" /><br>
	파라미터 2: <c:out value="${file2}" /><br>
	
	<c:if test="${not empty file1}">
		<img src="${contextPath}/download?fileName=${file1}" width=300 height=300 /><br>	<!-- 파일 이름으로 서블릿에서 이미지를 다운로드해 표시 -->
	</c:if>
	
	<c:if test="${not empty file2}">
		<img src="${contextPath}/download?fileName=${file2}" width=300 height=300 /><br>
	</c:if>
	
	파일 내려받기: <a href="${contextPath}/download?fileName=${file2}">파일 내려받기</a><br>
</body>

</html>