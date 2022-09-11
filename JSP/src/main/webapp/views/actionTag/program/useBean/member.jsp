<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,actionTag.bean.*" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="memberDTO" class="actionTag.bean.MemberDTO"  scope="page" />	<!-- 유즈빈 액션 태그를 이용해 유즈빈을 만듦 -->
<jsp:setProperty name="memberDTO" property="*" />	<!-- 동일한 빈에 값을 자동으로 설정 -->

<%	
	MemberDAO memberDAO = new MemberDAO();
	memberDAO.addMember(memberDTO);	// 회원 정보를 테이블에 추가
	List<MemberDTO> membersList = memberDAO.listMembers();	// 전체 회원 정보 조회
%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원목록</title>
</head>

<body>
	<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
		<!-- 입력한 값 -->
		<tr align="center">	
			<th><jsp:getProperty name="memberDTO" property="id" /></th>
			<th><jsp:getProperty name="memberDTO" property="pwd" /></th>
			<th><jsp:getProperty name="memberDTO" property="name" /></th>
			<th><jsp:getProperty name="memberDTO" property="email" /></th>
			<th></th>
		</tr>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
		<!-- DB 전체 조회 -->
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
				MemberDTO bean = (MemberDTO) membersList.get(i);
%>
				<tr align="center">
					<td><%=bean.getId()%></td>
					<td><%=bean.getPwd()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getEmail()%></td>
					<td><%=bean.getJoinDate()%></td>
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