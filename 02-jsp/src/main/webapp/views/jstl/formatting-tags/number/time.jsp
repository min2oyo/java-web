<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>시간</title>
</head>

<body>
	
	<h2>숫자 포매팅</h2>
	<c:set var="price" value="100000000" />
	<fmt:formatNumber value="${price}" type="number" var="priceNumber" />

	통화로 표현 시: <fmt:formatNumber value="${price}" type="currency" groupingUsed="true" currencySymbol="￦" /><br>
	퍼센트로 표현 시: <fmt:formatNumber value="${price}" type="percent" groupingUsed="false" /><br>
	일반 숫자로 표현 시: ${priceNumber}
	
	<h2>formatDate 예제</h2> 
	<c:set var="now" value="${Date()}" />
	<fmt:formatDate value="${now}" type="date" dateStyle="full" /><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="short" /><br>
	<fmt:formatDate value="${now}" type="time" /><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
	<fmt:formatDate value="${now}" pattern="YYYY-MM-dd :hh:mm:ss" /><br>
	<br>
	
	한국 현재 시간:
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
	<fmt:timeZone value="America/New York">
		뉴욕 현재 시간:
		<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
	</fmt:timeZone>
	
</body>

</html>