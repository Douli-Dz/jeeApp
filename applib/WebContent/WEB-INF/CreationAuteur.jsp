<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Creation Auteur</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/style.css"/>" />
</head>
<body>

	<form method="post" action="<c:url value="/CreationAuteur "/>">
	
		<fieldset>
			<legend>Informations Auteur</legend>
			<label for="numAuteur">Num<span class="requis">*</span></label> 
			<input type="text" id="numAuteur" name="numAuteur" value="<c:out value=" ${auteur.num} "/>" size="30" maxlength="30" />
			<span class="erreur">${form.erreurs['numAuteur']}</span> <br /> 
			
			<label for="nomAuteur">Nom<span class="requis">*</span></label>
			<input type="text" id="nomAuteur" name="nomAuteur" value="<c:out value=" ${auteur.nom} "/>" size="30" maxlength="30" />
			<span class="erreur">${form.erreurs['nomAuteur']}</span> <br /> 
			
			<label for="prenomAuteur">Prénom <span class="requis">*</span></label> 
		    <input type="text" id="prenomAuteur" name="prenomAuteur" value="<c:out value=" ${auteur.prenom} "/>" size="30" maxlength="60" />
			<span class="erreur">${form.erreurs['prenomAuteur']}</span> <br /> 
			
			<label for="domaineLivre">Date Naissance <span class="requis">*</span></label>
			<input type="date" id="dateNaissanceAuteur" name="dateNaissanceAuteur" value="<c:out value=" ${auteur.dateNaissance} "/>" size="30"maxlength="30" /> 
			<span class="erreur">${form.erreurs['dateNaissanceAuteur']}</span>
			<br />
		</fieldset>
		<p class="info">${ form.resultat }</p>
		<input type="submit" value="Valider" class="button" /> 
			<input type="reset" value="Remettre à zéro" class="button" /> <br />

	</form>
	
	<form method="post" action="HomeAdmin">

		<fieldset>
			<legend>Accueil</legend>
			<p>Retour vers page admin</p>
			<br> <input type="submit" value="accueil" class="button" />
		</fieldset>

	</form>
	
</body>
</html>