<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	session.setAttribute("name", "이혜리");
	application.setAttribute("address", "서울시 강남구");
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>내장 객체 스코프 테스트 1</title>
</head>

<body>
	<h1>이름과 주소를 저장합니다</h1>
	<a href="application2.jsp">두 번째 웹 페이지로 이동</a>
</body>

</html>