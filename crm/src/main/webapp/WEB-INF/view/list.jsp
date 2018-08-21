<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			CRM- Customer Relation Management
		</div>		
	</div>
	
	
	<div id="container">
		
		 <div id="content">
		 	<input type="button" value="Add Customer" onclick="window.location.href='showForm'"/>
		 	<br>
		 	<table>
				<tr> 
					<th> First Name </th>
					<th> Last Name </th>
					<th> Email </th>
					<th> Action </th>
				</tr>
				
				<c:forEach var="theCustomers" items="${customer}">
						<!-- for update customer  -->
					<c:url var="updateLink" value="/showFormForUpdate">
						<c:param name="customerId" value="${theCustomers.id }"></c:param>
					</c:url>
					
						<!-- for delete customer  -->
					<c:url var="deleteLink" value="/delete">
						<c:param name="customerId" value="${theCustomers.id }"></c:param>
					</c:url>
					
					<tr>
						<td> ${theCustomers.firstName} </td>
						<td> ${theCustomers.lastName} </td>
						<td> ${theCustomers.email} </td>
						<td> 
							<a href="${updateLink}">Update</a>   
								|
							<a href="${deleteLink}"
							 onclick="if (!(confirm('are you sure you want to delete this customer?'))) return false" >Delete</a>	 
						
						</td>
					
					</tr>
					
				</c:forEach>
		
			</table> 
		 
		 </div>
	
	</div>
	
	

</body>
</html>











