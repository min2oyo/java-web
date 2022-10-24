<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
	int score = Integer.parseInt(request.getParameter("score"));
	
	String grade;
	if (score >= 90) grade = "A";
	else if (score >= 80) grade = "B";
	else if (score >= 70) grade = "C";
	else if (score >= 80) grade = "D";
	else grade = "F";
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>점수 출력 창</title>
</head>

<body>
	<h1>시험 점수: <%= score %>점</h1>
	<h1><%= grade %>학점입니다</h1>
	<h1><a href="score.html"><button>다시 하기</button></a></h1>
</body>

</html>