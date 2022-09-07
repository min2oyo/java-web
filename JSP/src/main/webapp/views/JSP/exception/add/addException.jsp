<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>에러 페이지</title>
</head>

<body>
	toString() 내용<br>
	<h1><%= exception.toString() %></h1>
	getMessage() 내용<br>
	<h1><%= exception.getMessage() %></h1>
	printStackTrace() 내용<br>
	<h1><% exception.printStackTrace(); %></h1>	<!-- 	콘솔로 예외 메시지 출력 -->
	<h3>
		숫자만 입력가능합니다. 다시 시도하세요<br>
		<a href="add.html">다시 하기</a>
	</h3>
</body>

</html>