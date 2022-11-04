<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<c:url var="url1" value="/views/jstl/core/member.jsp">
	<c:param name="id" value="shin" />
	<c:param name="pwd" value="1212" />
	<c:param name="name" value="신세경" />
	<c:param name="email" value="shin@jweb.com" />
</c:url>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>c:url</title>
</head>

<body>
	<a href="${url1}">회원 정보</a>
</body>

</html>