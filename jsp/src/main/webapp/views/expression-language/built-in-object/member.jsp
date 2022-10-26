<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberVO" class="member.MemberVO" />
<jsp:setProperty property="*" name="memberVO" />

<jsp:useBean id="address" class="member.Address" />
<jsp:setProperty property="city" name="address" value="서울" />
<jsp:setProperty property="zipcode" name="address" value="07654" />

<jsp:useBean id="membersList" class="java.util.ArrayList" />
<jsp:useBean id="membersMap" class="java.util.HashMap" />

<%
	memberVO.setAddress(address);
	membersList.add(memberVO);
	membersMap.put("membersList", membersList);
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 정보</title>
	<style>
		table, main {
			width: 1000px;
		}
		main {
			margin: 0 auto;
		}
	</style>
</head>

<body>
	<main>
		<h2 align="center">회원 정보</h2>
		<div align="right"><a href="${pageContext.request.contextPath}/views/expression-language/built-in-object/sign-up.jsp"><button>회원가입</button></a></div>
		<table>
			<tr align="center" bgcolor="#99ccff">
				<th>종류</th>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>도시</td>
				<td>우편번호</td>
				<td>주소</td>
			</tr>
			<tr align="center">
				<td>param</td>
				<td>${param.id}</td>
				<td>${param.pwd}</td>
				<td>${param.name}</td>
				<td>${param.email}</td>
				<td>(없음)</td>
				<td>(없음)</td>
				<td>${requestScope.address}</td>
			</tr>
			<tr align="center">
				<td>memberVO</td>
				<td>${memberVO.id}</td>
				<td>${memberVO.pwd}</td>
				<td>${memberVO.name}</td>
				<td>${memberVO.email}</td>
				<td>${memberVO.address.city}</td>
				<td>${memberVO.address.zipcode}</td>
				<td>${requestScope.address}</td>
			</tr>
			<tr align="center">
				<td>ArrayList</td>
				<td>${membersList[0].id}</td>
				<td>${membersList[0].pwd}</td>
				<td>${membersList[0].name}</td>
				<td>${membersList[0].email}</td>
				<td>${membersList[0].address.city}</td>
				<td>${membersList[0].address.zipcode}</td>
				<td>${requestScope.address}</td>
			</tr>
			<tr align="center">
				<td>HashMap</td>
				<td>${membersMap.membersList[0].id}</td>
				<td>${membersMap.membersList[0].pwd}</td>
				<td>${membersMap.membersList[0].name}</td>
				<td>${membersMap.membersList[0].email}</td>
				<td>${membersMap.membersList[0].address.city}</td>
				<td>${membersMap.membersList[0].address.zipcode}</td>
				<td>${requestScope.address}</td>
			</tr>
			<tr height="1" bgcolor="#99ccff">
				<td colspan="8"></td>
			</tr>
		</table>
	</main>
</body>

</html>