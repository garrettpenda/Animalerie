<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>

<div >
	
	Language : <a href="?lang=eng">English</a>|<a href="?lang=fr">Français</a> <br>
	
	<sec:authorize access="isAnonymous() " >
		<spring:message code="text.connected" text="connected* " />
		<form action="/PersonAnimals/login" method="post">
	        <div><label> <spring:message code="text.user" text="user* "/> <input type="text" name="username"/> </label></div>
	        <div><label> <spring:message code="text.password" text="password* "/> <input type="password" name="password"/> </label></div>
	        <div><input type="submit" value=<spring:message code="text.login" text="login* " /> /></div>
	 	</form>
	</sec:authorize>
	
  	<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()" >
    	<spring:message code="text.notconnected" text="notconnected* " /> <c:out value="${pageContext.request.userPrincipal.name}" /> <br>
     	<form action='<c:url value="/logout" />' method="POST"> <input type="submit" value=<spring:message code="text.logout" text="logout* " /> > </form>
	</sec:authorize>
	
	<a href="<c:url value='/' />" > <spring:message code="text.menu" text="return main menu*" /> </a> <br>
	<a href="<c:url value='/getAllPersons' />" > <spring:message code="text.menuperson" text="return to persons* " /> </a> <br>
	<a href="<c:url value='/getAllAnimals' />" > <spring:message code="text.menuanimal" text="return to animals* " /> </a> <br>
	<a href="<c:url value='/admin' />" > <spring:message code="text.admin" text="adminpage* " /> </a> <br>

</div>