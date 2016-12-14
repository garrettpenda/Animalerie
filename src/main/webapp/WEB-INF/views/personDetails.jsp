<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<title> <spring:message code="text.persons" text="animals*" /></title>
	<%@ include file="components/head.jsp" %>
	
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
			
			<form:form method="post" modelAttribute="person" action="${pageContext.request.contextPath}/addPerson">
			
				<table >  
					<tr>  
						<th colspan="2"><spring:message code="text.addperson" text="add person*" /></th>  
					</tr>  
					<tr>  
							<form:hidden path="id" />  
							<td><form:label path="name"> <spring:message code="text.firstname" text="firstname* "/> </form:label></td>  
							<td><form:input path="name" size="30" maxlength="30"></form:input></td>  
					</tr>  
					<tr>  
							<td><form:label path="lastname"> <spring:message code="text.lastname" text="default text" /></form:label></td>  
							<td><form:input path="lastname" size="30" maxlength="30"></form:input></td>  
					</tr> 
					<tr>  
							<td><form:label path="country"> <spring:message code="text.country" text="default text" /></form:label></td>  
							<td><form:input path="country" size="30" maxlength="30"></form:input></td>  
					</tr>  
					<tr>  
						<td colspan="2"><input type="submit"  /></td>  
					</tr>  
				</table>
				
			</form:form>
			
		</sec:authorize>
		<!-- -------------------- -->
  		<!-- TABLEAUX DES ANIMAUX -->
  		<!-- -------------------- -->
		
		<h3> <spring:message code="text.animals" text="animals*" /> </h3> 
		
		<c:if test="${!empty listOfAnimals}"> 
			<table >
				<tr>
		  			<th width="80"> <spring:message code="text.lastname" text="name*" /></th>
					<th width="80"> <spring:message code="text.type" text="type*" /> </th>
					<th width="80"> <spring:message code="text.sex" text="sex*" /> </th>
					<th width="80"> <spring:message code="text.edit" text="edit*" /> </th>
					<th width="80"> <spring:message code="text.delete" text="delete*" /> </th>
				<tr>
				<c:forEach items="${listOfAnimals}" var="animal">
					<tr>
			  			<td>${animal.getName()}</td>
						<td>${animal.getType()}</td>
						<td>${animal.getSex()}</td>
						<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()" >
							<td><a href="<c:url value='/updateAnimal/${animal.id}' />" > <spring:message code="text.edit" text="edit*" /> </a></td>
							<td><a href="<c:url value='/deleteAnimal/${animal.id}' />" > <spring:message code="text.delete" text="delete*" /> </a></td>  
						</sec:authorize>
					<tr>
				</c:forEach> 
			</table>
		</c:if>
  		
  		<!-- ---------------------- -->
  		<!-- TABLEAUX DES PERSONNES -->
  		<!-- ---------------------- -->
  		
  		<h3> <spring:message code="text.persons" text="persons*" /> </h3>
  		
  		<%-- <c:if test="${!empty listOfPersons}">  
			<p> il y a	${fn:length(listOfPersons)} personne(s) enregistrée(s) </p>
		</c:if>   --%>
  		
		<c:if test="${!empty listOfPersons}">  
			<table class="table table-bordered">  
				<tr>  
					 <th width="80"> <spring:message code="text.id" text="id*" /> </th>  
					 <th width="120"> <spring:message code="text.firstname" text="firstname*" /> </th>
					 <th width="120"> <spring:message code="text.lastname" text="lastname*" /> </th>    
					 <th width="120"> <spring:message code="text.country" text="country*" /> </th>  
					 <th width="60"> <spring:message code="text.showanimals" text="show animals*" /> </th>
					 <th width="60"> <spring:message code="text.edit" text="edit*" /> </th>
					 <th width="60"> <spring:message code="text.delete" text="delete*" /> </th> 
				</tr>  
				
				<c:forEach items="${listOfPersons}" var="person">  
			 		<tr>  
				  		<td>${person.id}</td>  
				  		<td>${person.name}</td>
				  		<td>${person.lastname}</td>  
				  		<td>${person.country}</td> 
				  		<td><a href="<c:url value='/showAnimals/${person.id}' />" > ${fn:length(person.lanim)} </a></td>
				  		<sec:authorize access="hasRole('ROLE_USER') and isAuthenticated()" >
							<td><a href="<c:url value='/updatePerson/${person.id}' />" > <spring:message code="text.edit" text="edit*" /> </a></td>
							<td><a href="<c:url value='/deletePerson/${person.id}' />" > <spring:message code="text.delete" text="delete*" /> </a></td>
						</sec:authorize>

			 		</tr>  
			 	</c:forEach> 
			  
			</table>  
		</c:if>  
		
		
		
		
	</body>
</html>