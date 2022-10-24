<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
	int number = Integer.parseInt(request.getParameter("number"));
%>

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
			<th colspan="2"><%= number %>단 출력</th>		
		</tr>
<%
		for (int i = 1; i < 10; i++) {
			if (i % 2 == 1) {
%>
				<tr align="center" bgcolor="#CCFF66">
<%
			} else {
%>
				<tr align="center" bgcolor="#CCCCFF">
<%
			}
%>
				<td width="400"><%= number %> * <%= i %></td>
				<td width="400"><%= number * i %></td>
			</tr>
<%
		}
%>
	</table>
</body>

</html>