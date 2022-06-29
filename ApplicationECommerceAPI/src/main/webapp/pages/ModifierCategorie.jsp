<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Surf&ampCo - Modifier catégorie</title>
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
	</style>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/admin/GestionCategorie/AjouterCategorie" method="post" modelAttribute="categorieM">
<h3> Ajoutez une cat&eacute;gorie </h3>
<form:input type="hidden" path="idCategorie"/>
<table>
<tr>
	<td><form:label path="nomCategorie">Nom de la cat&eacute;gorie :</form:label> </td>
	<td><form:input path="nomCategorie"/></td>
</tr>
<tr>
	<td><form:label path="description">Description :</form:label> </td>
	<td><form:input path="description"/></td>
</tr>
</table>
<input type="submit" value="Valider"/>
</form:form>

<br>

<!-- -------------- Bouton de retour -------------- -->
<form action="TraitementCategorie">
    <input type="submit" value="Retour" />
</form>

</body>
</html>