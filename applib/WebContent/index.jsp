<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>Accueil</title>
</head>
<body>

	<form method="post" action="login_admin.jsp">
		<fieldset>
			<legend>Admin Login</legend>

			<span>Êtes-vous Admin? <input type="submit" value="login" class="button" />
			</span>
		</fieldset>
	</form>
	<form method="post" action="Search">
		<fieldset>
			<legend>Search</legend>
			<p>
				<input type="text" id="search" placeholder="Search..." name="search" class="search" class="button"> 
				<input type="hidden" id="whosearch" name="whosearch" value="visitor"> 
				<select name="searchin" id="searchin" class="dropdown">
					<option value="auteur">Auteur</option>
					<option value="livre">Livre</option>
					<option value="domaine">Domaine</option>
				</select>
			</p>
			<input type="submit" value="Search" class="button"> 
				<span class="erreur">${message} </span>
		</fieldset>
	</form>
</body>

</html>