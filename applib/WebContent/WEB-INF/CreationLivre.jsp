<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Creation Livre</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/style.css"/>" />
</head>
<body>
		<form method="post" action="CreationLivre">
			<fieldset>
				<legend>Informations livre</legend>

				<label for="issnLivre">issn <span class="requis">*</span></label> 
				<input type="text" id="issnLivre" name="issnLivre" value="<c:out value="${livre.issn}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['issnLivre']}</span> <br /> 
				
				<label for="numAuteurLivre">Numéro Auteur <span class="requis">*</span></label> 
				<input	type="text" id="numAuteurLivre" name="numAuteurLivre" value="<c:out value="${livre.numAuteur}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['numAuteurLivre']}</span> <br /> 
				
				<label	for="titreLivre">Titre <span class="requis">*</span></label> 
				<input	type="text" id="titreLivre" name="titreLivre" value="<c:out value="${livre.titre}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['titreLivre']}</span> <br /> 
				
				<label	for="resumeLivre">Resume de livre <span class="requis">*</span></label>
				<input type="text" id="resumeLivre" name="resumeLivre" value="<c:out value="${livre.resume}"/>" size="30" maxlength="60" />
				<span class="erreur">${form.erreurs['resumeLivre']}</span> <br />
				
				<label	for="domaineLivre">Domaine <span class="requis">*</span></label> 
				<input	type="text" id="domaineLivre" name="domaineLivre" value="<c:out value="${livre.domaine}"/>" size="30" maxlength="30" />
				<span class="erreur">${form.erreurs['domaineLivre']}</span> <br />

				<label for="nbPagesLivre">Nombre pages<span class="requis">*</span></label>
				<input type="number" id="nbPagesLivre" name="nbPagesLivre" value="<c:out value="${livre.nbPages}"/>" size="30" maxlength="60" min='0' />
				 <span class="erreur">${form.erreurs['nbPagesLivre']}</span>
				<br />

			</fieldset>
			<p class="info">${ form.resultat }</p>
			<input type="submit" value="Valider" class="button" /> <input
				type="reset" value="Remettre à zéro" class="button" /> <br />
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