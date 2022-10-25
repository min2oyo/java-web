<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" import="jsp.search.*" pageEncoding="UTF-8" %>

<%
// 	request.setCharacterEncoding("utf-8");
// 	String searchName = request.getParameter("name");
// 	MemberVO memberVO1 = new MemberVO();
// 	memberVO1.setName(searchName);
// 	MemberDAO memberDAO = new MemberDAO();
// 	List<MemberVO> membersList = memberDAO.listMembers(memberVO1);	// 조건에 해당하는 회원 정보 조회
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 정보 출력 창</title>
	<style>
		h1 {
			text-align: center;
		}
	</style>
</head>

<body>
	<h1>회원 정보 출력</h1>
	<table border="1" width="800" align="center">
		<tr align="center" bgcolor="#ffff66">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일자</td>
		</tr>
<%
// 		for (int i = 0; i < membersList.size(); i++) {	// 조회한 회원 정보 출력
// 			MemberVO memberVO2 = (MemberVO) membersList.get(i);
// 			String id = memberVO2.getId();
// 			String pwd = memberVO2.getPwd();
// 			String name = memberVO2.getName();
// 			String email = memberVO2.getEmail();
// 			Date joinDate = memberVO2.getJoinDate();
%>
<!-- 			<tr align="center"> -->
<%-- 				<td><%= id %></td> --%>
<%-- 				<td><%= pwd %></td> --%>
<%-- 				<td><%= name %></td> --%>
<%-- 				<td><%= email %></td> --%>
<%-- 				<td><%= joinDate %></td> --%>
<!-- 			</tr> -->
<%
// 		}
%>
	</table>
	<a href="http://localhost:8080/JSP/views/JSP/search/search.jsp">다시 검색</a>

</body>

</html>