<%@page import="java.util.*"%>
<%@page import="member.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");

	MemberVO memberVO;

	// 내장 객체
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");
	session.setAttribute("name", "홍유진");
	application.setAttribute("email", "hong@jweb.com");
	request.setAttribute("address", "서울시 강남구");	// 중복, 우선순위 1
	
	// MemberVO
	memberVO = new MemberVO("lee", "1234", "이혜리", "lee@jweb.com");
	request.setAttribute("memberVO", memberVO);
	
	// ArrayList
	List<MemberVO> membersList = new ArrayList<MemberVO>();
	
	memberVO = new MemberVO("son", "1234", "손나은", "son@jweb.com");
	membersList.add(memberVO);
	request.setAttribute("membersList", membersList);
%>

<jsp:forward page="member.jsp" />