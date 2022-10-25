<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
%> 

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>include1.jsp</title>
</head>

<body>
	<div>안녕하세요. 쇼핑몰 중심 JSP 시작 부분입니다!</div>
	<jsp:include page="duke_image.jsp" flush="true">
		<jsp:param value="듀크" name="name" />
		<jsp:param value="duke.png" name="imgName" />
	</jsp:include>
	<div>안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다!</div>
</body>

</html>