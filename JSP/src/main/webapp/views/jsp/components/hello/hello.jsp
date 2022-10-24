<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%!
	String name = "이혜리";
	public String getName() {
		return name;
	}
%>

<%
	/* String age = request.getParameter("age"); */
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>표현식 연습</title>
</head>

<body>
	<!-- HTML 주석문입니다. -->
	<h1>안녕하세요, <%= name %>님!</h1>
	<%-- <h1>나이는 <%= age %>살입니다</h1> --%>
	<h1>키는 <%= 165 %>cm입니다</h1>
	<%-- <h1>나이+10은 <%= Integer.parseInt(age) + 10 %>살입니다</h1> --%>
</body>

</html>