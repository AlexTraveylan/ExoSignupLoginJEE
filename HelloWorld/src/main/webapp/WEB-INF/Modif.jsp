<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://myapp.fr/tld/extratags" prefix="mytags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier le compte</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>

<mytags:Header userName='Page pour modifier le compte : ${user.username }' />


<form method="post" style="margin-top:20px">
	<input type="hidden" name = "id_text" value="${user.id}">
	<label for="username_text">Changer de nom d'utilisateur</label>
	<input class="form_field" name = "username_text" type="text" value="${user.username }"><br>
		
	<label for="email_text">Changer l'email</label>
	<input class="form_field" name = "email_text" type="text" value="${user.email }"><br>
	
	<label for="password_text">Changer de mot de passe.</label>
	<input class="form_field" name ="password_text" type= "text" value="${user.password }"><br>
	<button type="submit">Valider</button>
</form>

</body>
</html>