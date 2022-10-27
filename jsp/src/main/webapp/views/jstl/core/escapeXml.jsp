<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>escapeXml</title>
</head>

<body>
	<h2>escapeXml 변환하기</h2>
		<c:out value="&lt;" escapeXml="true" /><br>
		<c:out value="&lt;" escapeXml="false" /><br>
		
		<c:out value="&gt;" escapeXml="true" /><br>
		<c:out value="&gt;" escapeXml="false" /><br>
		
		<c:out value="&amp;" escapeXml="true" /><br>
		<c:out value="&amp;" escapeXml="false" /><br>
		
		<c:out value="&#039;" escapeXml="true" /><br>
		<c:out value="&#039;" escapeXml="false" /><br>
		
		<c:out value="&#034;" escapeXml="true" /><br>
		<c:out value="&#034;" escapeXml="false" /><br>
</body>

</html>