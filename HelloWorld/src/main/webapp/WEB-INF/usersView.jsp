<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.jee.dao.UtilConnexion" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des utilisateurs</title>
		<link rel="stylesheet" href="css/style.css" type="text/css">
	</head>
	<body>
		<h1>Liste des utilisateurs</h1>
		<%
			Connection con = UtilConnexion.seConnecter();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
		%>
		
		
		<table>
			<tr> <th>ID</th> <th>Username</th> <th>email</th> <th>password</th> </tr>
			<% while (rs.next()) { %>
				<tr>
					<td> <%= rs.getInt(1) %> </td>
					<td> <%= rs.getString(2) %> </td>
					<td> <%= rs.getString(3) %> </td>
					<td> <%= rs.getString(4) %> </td>
					<td> <a href="supp?id=<%= rs.getInt(1) %>">Supprimer</a></td>
					<td> <a href="modif?id=<%= rs.getInt(1) %>">Modifer</a></td>
				</tr>
			<%
			}
			con.close();
			rs.close();
			%>
		</table>
		
		<p><a href="login">Ajouter un élement</a></p>
		<p><a href="connect">Se connecter</a></p>
		
	
	</body>
</html>