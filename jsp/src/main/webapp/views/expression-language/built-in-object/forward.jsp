<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("address", "서울시 강남구");
%>

<jsp:forward page="member.jsp" />