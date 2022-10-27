<%@ page import="member.MemberVO" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="memberVO" class="member.MemberVO" />
<jsp:setProperty name="memberVO" property="*"  />
<jsp:useBean id="memberDAO" class="member.MemberDAO" />

<%
	memberDAO.addMember(memberVO);
 	List<MemberVO> membersList = memberDAO.listMembers();
	request.setAttribute("membersList", membersList);
%>

<jsp:forward page="member.jsp" />
