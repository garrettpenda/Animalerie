<%@page session="false" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> <spring:message code="text.title" text="title* " /></title>
	</head>
	
	<body>
	
		<%@ include file="components/side-bar.jsp" %>
		
		<h1> <spring:message code="text.welcome" text="welcome* " />  </h1>
		
		<div>PAGE ADMIN</div>
		<div>${name}</div>
		<div>${autori}</div>
		Current Locale : ${pageContext.response.locale} <br>
	
	</body>

</html>