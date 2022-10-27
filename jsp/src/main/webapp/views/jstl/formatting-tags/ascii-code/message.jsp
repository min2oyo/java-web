<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL 다국어 기능</title>
</head>

<body>
	<fmt:setLocale value="en_US"/>
<%-- 	<fmt:setLocale value="ko_Kr"/> --%>
	<h2>회원 정보</h2>
	<fmt:bundle basename="resource.member">
		이름: <fmt:message key="mem.name" /><br>
		주소: <fmt:message key="mem.address" /><br>
		직업: <fmt:message key="mem.job" /><br>
	</fmt:bundle>
</body>

</html>