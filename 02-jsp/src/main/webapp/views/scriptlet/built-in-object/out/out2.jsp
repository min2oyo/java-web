<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
	String name = (String) request.getParameter("name");
	String age = (String) request.getParameter("age");
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>out 2</title>
</head>

<body>
<%
	if (name.length() != 0 && name != null) {
%>
		<h1><% out.println("이름: " + name); %></h1>
		<h1><% out.println("나이: " + age); %></h1>
<%
	} else {
%>
	<h1>이름을 입력하세요</h1>
<%
	}
%>
</body>

</html>