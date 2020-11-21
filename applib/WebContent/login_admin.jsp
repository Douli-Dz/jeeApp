<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>Admin Login</title>

</head>
<body>

	<div class='center-screen'>
		<form action="AdminLogin" method="post">
			<fieldset>
				<legend>Admin Login</legend>
				<label for="username">Username :</label> 
					<input name="username" size="30" /> <br><br> 
				<label for="password">Password :</label> 
					<input type="password" name="password" size="30" /><br><br>
				<span class="erreur">${message} </span> <br> <br>
					<button type="submit" class="button">Login</button>
			</fieldset>
		</form>
		<br/>
	</div>
	
</body>
</html>