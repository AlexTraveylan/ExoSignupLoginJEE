<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />

<title>Page de Login</title>
</head>
<body>
	<h1>Créer votre compte</h1>
	<c:if test="${user != null}">
		<p class="msg_bonjour">L'utilisateur est : ${user.username}, son email est : ${user.email }, il a entré comme mot de passe : ${user.password }</p>
		<p class="${color}">${connected}</p>
	</c:if>
	
	
	<p class="erreur">${ erreur }</p>
	
		<form class = "login_form" action="" method = "POST">
			<label for="username">Username</label>
			<input class="form_field" name="username" type="text" placeholder="Username"><br>
			<label for="email">Email</label>
			<input class="form_field" name="email" type="text" placeholder="email"><br>
			<label for="password">Password</label>
			<input class="form_field" name="password" type="password"><br>
			<label for="confirme">Confirm password</label>
			<input class="form_field" name="confirme" type="password"><br>
			<input class="btn_form" type="submit" value="Submit">
		</form>
	
</body>
</html>