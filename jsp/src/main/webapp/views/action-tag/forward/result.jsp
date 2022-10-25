<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
	String userID = request.getParameter("userID");
	String msg = "아이디를 입력하지 않았습니다. 아이디를 입력해주세요";
	
	if (userID.length() == 0) {
%>
		<jsp:forward page="login.jsp">
			<jsp:param value="<%= msg %>" name="msg" />
		</jsp:forward>
<%
	}
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인 결과</title>
</head>

<body>
	<h1>환영합니다 <%= userID %>님!</h1>
</body>

</html>