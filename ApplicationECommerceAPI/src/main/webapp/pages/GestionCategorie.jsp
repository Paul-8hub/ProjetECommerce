<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Surf&ampCo - Gestion des cat&eacute;gories</title>
	<style>
		h2 {
			text-align: center;
			color: navy;
		}
		h3 {
			color: midnightBlue;
		}
		body {
    		background-color: Wheat;
    		font-family:Arial, Helvetica, sans-serif;
		}
		.AffCat {
			border: 1px solid;
			text-align: center;
		}
		table {
			border-collapse: collapse;
		}
	</style>
</head>
<body>

<h2> Gestion des cat&eacute;gories </h2>

<form:form action="AjouterCategorie" method="post" modelAttribute="categorie"> <!-- On recoit un objet vide categorie de type categorie -->

<h3> Ajoutez une cat&eacute;gorie </h3>
<table>
<tr>
	<td>Nom de la cat&eacute;gorie : </td>
	<td><form:input type="text" path="nomCategorie"/></td>
</tr>
<tr>
	<td>Description de la cat&eacute;gorie : </td>
	<td><form:input type="text" path="description"/></td>
</tr>
</table>
<input type="submit" value="Valider">
</form:form>

<br> 

<h3> Cat&eacute;gories existantes </h3>
<table class="AffCat">
	<tr class="AffCat">
		<td class="AffCat">Id cat&eacute;gorie</td>
		<td class="AffCat">Nom de la cat&eacute;gorie</td>
		<td class="AffCat">Description de la cat&eacute;gorie</td>
		<td class="AffCat"></td>
		<td class="AffCat"></td>
		<td class="AffCat">Produits associ&eacute;s</td>
	</tr>
	<c:forEach items="${ListC}" var="c">
	<tr class="AffCat">
		<td class="AffCat">${c.idCategorie}</td>
		<td class="AffCat">${c.nomCategorie}</td>
		<td class="AffCat">${c.description}</td>
		<td class="AffCat"><a href="SupprimerCategorie?id=${c.idCategorie}">Supprimer</a></td>
		<td class="AffCat"><a href="ModifierCategorie/${c.idCategorie}">Modifier</a></td>
		<td class="AffCat"><a href="ProduitsAssocies?id=${c.idCategorie}">Afficher</a></td>
	</tr>
	</c:forEach>
</table>

<br>

<!-- -------------- Bouton de retour -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/admin/">
    <input type="submit" value="Retour"/>
</form:form>

<br>

<!-- -------------- Bouton de déconnexion -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="D&eacute;connexion"/>
</form:form>

</body>
</html>