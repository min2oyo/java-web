<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:redirect url="/views/jstl/core/member.jsp">
	<c:param name="id" value="${'bae'}" />
	<c:param name="pwd" value="${'1212'}" />
	<c:param name="name" value="${'배슬기'}" />
	<c:param name="email" value="${'bae@jweb.com'}" />
</c:redirect>