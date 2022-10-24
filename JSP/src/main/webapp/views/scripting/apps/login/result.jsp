<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
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
<%
	if (userId == null || userId.length() == 0) {
%>
		아이디를 입력하세요<br>
		<a href="login.jsp">로그인 하기</a>
<%		
	} else if (userId.equals("admin")) {
%>
		<h1>관리자로 로그인했습니다</h1>
		<form>
			<input type="button" value="회원정보 수정" />
			<input type="button" value="회원정보 삭제" />
		</form>
<%		
	} else {
%>
		<h1>환영합니다. <%= userId %>님!</h1>
<%-- 		<h1>비밀번호: <%= userPw %></h1> --%>
<%		
	} 
%>
</body>

</html>