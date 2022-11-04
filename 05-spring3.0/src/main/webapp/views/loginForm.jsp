<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인</title>
</head>

<body>
	<form action="/spring3.0/views/login.do" method="post" name="frmLogin">
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td>아이디</td>
				<td>비밀번호</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="userID" value="" size="20"></td>
				<td><input type="password" name="passwd" value="" size="20"></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="로그인"><input type="reset" value="다시 입력"></td>
			</tr>
		</table>
	</form>
</body>

</html> 



