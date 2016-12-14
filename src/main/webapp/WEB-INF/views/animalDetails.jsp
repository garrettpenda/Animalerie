<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
		
		<title> <spring:message code="text.animals" text="animals*" /></title>
	</head>
	
	<body>
	
		<!-- ---- -->
		<!-- MENU -->	
		<!-- ---- -->

		<%@ include file="components/side-bar.jsp" %>
			
		<!-- ---------- -->
		<!-- FORMULAIRE -->	
		<!-- ---------- -->
		
		<h3> <spring:message code="text.form" text="form*" /> </h3> 
		
		<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()" >
			<form:form method="post" modelAttribute="animal" action="${pageContext.request.contextPath}/addAnimal">  
				<table>  
					<tr>  
						<th colspan="2"> <spring:message code="text.addanimal" text="add animals* " /></th>  
					</tr>  
					<tr>  
							<form:hidden path="id" />
							<form:hidden path="person.id" /> 
							 
							<td><form:label path="name"> <spring:message code="text.lastname" text="name* " /></form:label></td>  
							<td><form:input path="name" size="30" maxlength="30"></form:input></td>  
					</tr>  
					<tr>  
							<td><form:label path="type"> <spring:message code="text.type" text="type* " /></form:label></td>  
							<td><form:input path="type" size="30" maxlength="30"></form:input></td>  
					</tr> 
					<tr>  
							<td><form:label path="sex"> <spring:message code="text.sex" text="sex* " /></form:label></td>  
							<td><form:input path="sex" size="30" maxlength="30"></form:input></td>  
					</tr> 
					<tr>  
						<td colspan="2"><input type="submit"  /></td>  
					</tr>  
				</table>   
			</form:form> 
		</sec:authorize>
		<!-- ---------------------- -->
  		<!-- TABLEAUX DES PERSONNES -->
  		<!-- ---------------------- -->
		
		<h3> <spring:message code="text.person" text="person*" /> </h3> 
		
		<c:if test="${!empty listOfPerson}"> 
			<table >
				<tr>
		  			<th width="80"> <spring:message code="text.firstname" text="name*" /></th>
					<th width="80"> <spring:message code="text.lastname" text="lastname*" /> </th>
					<th width="80"> <spring:message code="text.country" text="country*" /> </th>
				<tr>
				<c:forEach items="${listOfPerson}" var="person">
					<tr>
			  			<td>${person.getName()}</td>
						<td>${person.getLastname()}</td>
						<td>${person.getCountry()}</td>
					<tr>
				</c:forEach> 
			</table>
		</c:if>
		
		<!-- -------------------- -->
		<!-- TABLEAUX DES ANIMAUX -->
		<!-- -------------------- -->
	
		<h3> <spring:message code="text.animals" text="animals list* " /></h3> 
		
		<c:if test="${!empty listOfAnimals}">  
			<table class="tg">  
				<tr>  
					 <th width="80"> <spring:message code="text.id" text="id* " /> </th>  
					 <th width="120"> <spring:message code="text.lastname" text="name* " /> </th>  
					 <th width="120"> <spring:message code="text.type" text="type* " /></th> 
					 <th width="60"> <spring:message code="text.sex" text="sex* " /></th> 
					 <th width="100"> <spring:message code="text.personid" text="personid*" /></th>
					 <th width="60"> <spring:message code="text.edit" text="edit* " /></th>  
					 <th width="60"> <spring:message code="text.delete" text="delete* " /></th>  
				</tr>  
				
				<c:forEach items="${listOfAnimals}" var="animal">  
			 		<tr>  
				  		<td>${animal.id}</td>  
				  		<td>${animal.name}</td>  
				  		<td>${animal.type}</td>
				  		<td>${animal.sex}</td>
				  		<td><a href="<c:url value='/showPerson/${animal.person.id}' />" > ${animal.person.id} </a></td> 
				  		<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()" >
							<td><a href="<c:url value='/updateAnimal/${animal.id}' />" > <spring:message code="text.edit" text="edit* " /> </a></td>
							<td><a href="<c:url value='/deleteAnimal/${animal.id}' />" > <spring:message code="text.delete" text="delete* " /> </a></td> 
						</</sec:authorize>
			 		</tr>  
			 	</c:forEach> 
			  
			</table>  
		</c:if>  
		

		
	
	</body>
</html>