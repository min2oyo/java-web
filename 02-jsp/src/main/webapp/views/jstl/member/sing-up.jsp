<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
</head>

<body>

	<form action="member_ok.jsp" method="post">
		<h1 style="text-align: center">회원가입</h1>
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</p></td>
				<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</p></td>
				<td width="400"><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><p><input type="text" name="name"></p></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</td>
				<td width="400"><p><input type="email" name="email"></td>
			</tr>
			<tr>
				<td width="200"><p>&nbsp;</p></td>
				<td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시 입력"></td>
			</tr>
		</table>
	</form>
	
</body>

</html>