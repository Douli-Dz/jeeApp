<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Home Admin</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/style.css"/>" />
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="<c:url value="/CreationAuteur"/>">Ajouter un Nouveau auteur</a></li>
			<li><a href="<c:url value="/CreationLivre"/>">Ajouter un Nouveau Livre</a></li>
		</ul>
	</div>

	<form method="post" action="Search">
		<fieldset>
			<legend>Search</legend>
			<p>
				<input type="text" id="search" placeholder="Search..." name="search"
					class="search" class="button"> <input type="hidden" id="whosearch" name="whosearch" value="visitor"> 
				<select name="searchin" id="searchin" class="dropdown">
					<option value="auteur">Auteur</option>
					<option value="livre">Livre</option>
					<option value="domaine">Domaine</option>
				</select>
			</p>
			<input type="submit" value="Search" class="button"> <span
				class="erreur">${message} </span>

		</fieldset>
	</form>
</body>
</html>