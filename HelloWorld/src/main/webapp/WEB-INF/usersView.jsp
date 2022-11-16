<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://myapp.fr/tld/extratags" prefix="mytags" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des utilisateurs</title>
		<link rel="stylesheet" href="css/style.css" type="text/css">
	</head>
	<body>
		<mytags:Header userName='Page des utilisateurs (${users.size()} utilisateurs)' />
		
		<div style="margin-top:40px">
			<div class="table__container">
				<table>
					<tr> <th>ID</th> <th>Username</th> <th>email</th> <th>password</th> </tr>
					
					<c:forEach items="${users}" var="user">
						<tr>
			          		<td> <c:out value='${user.id}'/> </td>
			          		<td> <c:out value='${user.username}'/> </td>
			          		<td> <c:out value='${user.email}'/> </td>
			          		<td> <c:out value='${user.password}'/> </td>
			          		<td> <a href='modif?id=<c:out value='${user.id}'/>'>Update</a></td>			
							<td> <a href='supp?id=<c:out value='${user.id}'/>'>Delete</a></td>	
						</tr>
					</c:forEach>
		
				</table>
				
				
				<p><a href="login">Ajouter un élement</a></p>
				<p><a href="connect">Se connecter</a></p>
			</div>
		</div>
		
		
	
	</body>
</html>