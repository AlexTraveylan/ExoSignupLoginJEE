<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://myapp.fr/tld/extratags" prefix="mytags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Se connecter</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<mytags:Header userName='Page de connexion' />

<h2>Message : ${msg}</h2>

<form method="post">
	<label for="username_text">Username :</label>
	<input class="form_field" name = "username_text" type="text" placeholder="Nom d'utilisateur"><br>
	
	<label for="password_text">Password</label>
	<input class="form_field" name ="password_text" type="password"><br>
	
	<button type="submit">Valider</button>
</form>

<p><a href="login">Créer un compte</a></p>
<p><a href=users>Liste des comptes</a></p>

</body>
</html>