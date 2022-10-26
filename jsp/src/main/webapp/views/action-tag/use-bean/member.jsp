<%@page import="java.util.*"%>
<%@page import="member.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberVO" class="member.MemberVO" />
<jsp:useBean id="memberDAO" class="member.MemberDAO" />

<%
	if (request.getParameter("id") != null) {	// 회원가입
%>
		<jsp:setProperty property="*" name="memberVO" />
<%
		memberDAO.addMember(memberVO);	
	}
	List<MemberVO> membersList = memberDAO.listMembers();	// 회원 목록
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 목록</title>
</head>

<body>
	<h2 align="center">회원 목록</h2>
	<div align="right"><a href="memberForm.jsp"><button>회원가입</button></a></div>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
<%
		if (membersList.size() == 0) {
%>
			<tr>
				<td colspan="5">
					<p align="center">
						<b><span style="font-size: 9pt;">등록된 회원이 없습니다.</span></b>
					</p>
				</td>
			</tr>
<%
		} else {

			for (int i = 0; i < membersList.size(); i++) {
				
				memberVO = (MemberVO) membersList.get(i);
%>
					<tr align="center">
						<td><%= memberVO.getId() %></td>
						<td><%= memberVO.getPwd() %></td>
						<td><%= memberVO.getName() %></td>
						<td><%= memberVO.getEmail() %></td>
						<td><%= memberVO.getJoinDate() %></td>
					</tr>
<%
			}

		}
%>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>
</body>

</html>