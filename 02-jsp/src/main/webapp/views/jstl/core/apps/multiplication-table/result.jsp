<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("utf-8"); %>
	
<c:set var="number" value="${param.number}" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>구구단 결과</title>
</head>

<body>
	<table border="1" width="800">
		<tr align="center" bgcolor="#FFFF66">
			<th colspan="2">${number}단 출력</th>		
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr align="center" bgcolor="${(i % 2 == 0) ? #CCCCFF : #CCFF66} ">
				<td width="400">${number} * ${i}</td>
				<td width="400">${number * i}</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>