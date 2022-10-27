<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인</title>
</head>

<body>
	<form action="result.jsp" method="post">
		아이디: <input type="text" name="userId" /><br>
		비밀번호: <input type="password" name="userPw" /><br>
		<input type="submit" value="로그인" />
		<input type="reset" value="다시 입력" />
	</form>
</body>

</html>