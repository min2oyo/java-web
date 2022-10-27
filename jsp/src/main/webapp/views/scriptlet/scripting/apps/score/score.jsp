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
	<title>학점 계산</title>
</head>

<body>
	<h1>시험 점수를 입력해주세요</h1>
	<form action="score.jsp">
		시험 점수: <input type="number" name="score" /><br>
		<input type="submit" value="변환" /><br>
	</form>
	
<%
	if (score >= 0 && score <= 100) {
%>
		<h1>시험 점수: <%= score %>점</h1>
		<h1><%= grade %>학점입니다</h1>
		<h1><a href="score.jsp?score=-1"><button>다시 하기</button></a></h1>
<%
	}
%>
</body>

</html>