<%@ page import="member.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("utf-8"); %>

<!-- Core -->
<c:set var="id" value="hong" />
<c:set var="pwd" value="1212" />
<c:set var="name" value="${'홍유진'}" />
<c:set var="age" value="${22}" />
<c:set var="height" value="${167}" />
<c:set var="email" value="${'hong@jweb.com'}" />
<c:set var="size" value="15cm" />
<c:remove var="size" />

<!-- HashMap -->
<jsp:useBean id="membersMap" class="java.util.HashMap" />
<%
	membersMap.put("id", "park");
	membersMap.put("pwd", "1212");
	membersMap.put("name", "박민영");
	membersMap.put("age", "22");
	membersMap.put("email", "park@jweb.com");
%>

<!-- MemberVO -->
<jsp:useBean id="membersList1" class="java.util.ArrayList" />
<%
	MemberVO memberVO = new MemberVO("son", "1212", "손나은", "son@jweb.com");
	
	membersList1.add(memberVO);
	membersMap.put("membersPut", membersList1);
%>
<c:set var="membersPut" value="${membersMap.membersPut}" />

<!-- c:forEach -->
<jsp:useBean id="membersList2" class="java.util.ArrayList" />
<%
	MemberVO memberVO1 = new MemberVO("lee", "1212", "이혜리", "lee@jweb.com");
	MemberVO memberVO2 = new MemberVO("kim", "1212", "김서현", "kim@jweb.com");
	MemberVO memberVO3 = new MemberVO("ki", "1212", "기희연", "ki@jweb.com");
	membersList2.add(memberVO1);
	membersList2.add(memberVO2);
	membersList2.add(memberVO3);
%>
<c:set var="membersList2" value="${membersList2}" />

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 정보</title>
</head>

<body>
	<h2 align="center">회원 정보</h2>
	<table align="center">
		<tr align="center" bgcolor="lightgreen">
			<th width="150">종류</th>
			<td width="150">아이디</td>
			<td width="150">비밀번호</td>
			<td width="150">이름</td>
			<td width="150">이메일</td>
		</tr>
		<c:choose>
			<c:when test="${empty param.id}">
				<tr align="center">
					<td colspan="5">아이디를 입력하세요!!</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr align="center">
					<td>Request</td>
					<td>${param.id}</td>
					<td>${param.pwd}</td>
					<td>${param.name}</td>
					<td>${param.email}</td>
				</tr>
				<tr align="center">
					<td>Core</td>
					<td>${id}</td>
					<td>${pwd}</td>
					<td>${name}</td>
					<td>${email}</td>
				</tr>
				<tr align="center">
					<td>HashMap</td>
					<td>${membersMap.id}</td>
					<td>${membersMap.pwd}</td>
					<td>${membersMap.name}</td>
					<td>${membersMap.email}</td>
				</tr>
				<tr align="center">
					<td>memberVO</td>
					<td>${membersPut[0].id}</td>
					<td>${membersPut[0].pwd}</td>
					<td>${membersPut[0].name}</td>
					<td>${membersPut[0].email}</td>
				</tr>
				<c:forEach var="i" begin="0" end="${membersList2.size() - 1}" step="1">
					<tr align="center">
						<td>forEach</td>
						<td>${membersList2[i].id}</td>
						<td>${membersList2[i].pwd}</td>
						<td>${membersList2[i].name}</td>
						<td>${membersList2[i].email}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>

	<h2>조건문</h2>
	<c:if test="${true}">
		<p>항상 참입니다</p>
	</c:if>
	<c:if test="${11 == 11}">
		<p>두 값은 같습니다</p>
	</c:if>
	<c:if test="${11 != 31}">
		<p>두 값은 같지 않습니다</p>
	</c:if>
	<c:if test="${(id == 'hong') && (name == '홍유진')}">
		<p>아이디는 ${id}이고, 이름은 ${name}입니다</p>
	</c:if>
	<c:if test="${age == 22}">
		<p>${name}의 나이는 ${age}살입니다</p>
	</c:if>
	<c:if test="${height > 160}">
		<p>${name}의 키는 160보다 큽니다</p>
	</c:if>
	
	<h2>반복문</h2>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i = ${i} &nbsp;&nbsp;&nbsp; 반복횟수: ${loop.count}<br>
	</c:forEach>
	<br>
	
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${i} = ${5 * i}<br>
	</c:forEach>
	<br>
	
	<jsp:useBean id="dataList" class="java.util.ArrayList" />
<%
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕하세요!!");
%>
	<c:forEach var="data" items="${dataList}">
		${data}<br>
	</c:forEach>
	<br>
	
	<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
	<c:forTokens var="token" items="${fruits}" delims=", ">
		${token}<br>
	</c:forTokens>
	<br>

</body>

</html>