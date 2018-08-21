<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
#edit{

background-color:rgb(120,120,120);
color:white;
text-align:center;
padding:225px;
}


</style>
</head>
<body id="edit" >

<h2>Basic Information</h2>
<p>Please Fill up the following information </p>
<p>Hello dear ;) Baby I love you ;) </p>

	 <form:form action="processForm" modelAttribute="customer">
	 	
	 	<form:hidden path="id"/> <!-- for update operation -->
	 																				
		  First name:
		  <form:input path="firstName"/>
		  <br><br>
		  Last name:
		  <form:input path="lastName" />
		  <br><br>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email :
		  <form:input path="email"  />
		  <br><br>
		  <input type="submit" value="Submit">
	</form:form>  
	<br> <br>
	<a href="${pageContext.request.contextPath}/list" >Back to list</a>

</body>
</html>
    