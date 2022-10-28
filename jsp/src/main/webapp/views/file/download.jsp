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
	<title>파일 다운로드</title>
</head>

<body>
	<form action="download_ok.jsp" method="post">
		<input type=hidden name="param1" value="duke.png" /><br>	<!-- 다운로드할 파일 이름을 매개변수로 전달 -->
		<input type=hidden name="param2" value="duke2.png" /><br>
		<input type="submit" value="이미지 다운로드" />	 
	</form>
</body>

</html>