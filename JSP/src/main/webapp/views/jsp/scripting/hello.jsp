<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%!
	String name = "이혜리";
	public String getName() {
		return name;
	}
%>

<%
	String age = request.getParameter("age");

// 	자바 주석
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>선언문, 스크립틀릿, 표현식</title>
</head>

<body>
	<h1>안녕하세요, <%= name %>님!</h1>
	<h1>나이는 <%= age %>살입니다</h1>
	<h1>키는 <%= 165 %>cm입니다</h1>
	<h1>나이+10은 <%= Integer.parseInt(age) + 10 %>살입니다</h1>

	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
</body>

</html>