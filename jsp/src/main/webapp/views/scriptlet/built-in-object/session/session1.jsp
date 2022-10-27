<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String name = (String) session.getAttribute("name");
	session.setAttribute("address", "서울시 강남구");
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>session 1</title>
</head>

<body>
	이름은 <%= name %>입니다<br>
	<a href="session2.jsp">두 번째 페이지로 이동</a>
</body>

</html>