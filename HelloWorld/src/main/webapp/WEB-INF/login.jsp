<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://myapp.fr/tld/extratags" prefix="mytags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />

<title>Page de Login</title>
</head>
<body>

<mytags:Header userName='Page de création de compte' />

	
		<form class = "login_form" action="" method = "POST" style="margin-top:20px">
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