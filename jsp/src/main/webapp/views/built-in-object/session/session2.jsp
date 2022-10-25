<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	String name = (String) session.getAttribute("name");
	String address = (String) session.getAttribute("address");
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>session 2</title>
</head>

<body>
	이름은 <%= name %>입니다<br>
	주소는 <%= address %>입니다<br>
</body>

</html>