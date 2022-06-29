<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Spring - Acc&egrave;s refus&eacute;</title>

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
<br> 
	
<!-- Tableau de produits -->
<table class="AffProduits">
	<tr class="AffProduits">
		<td class="AffProduits">idProduit</td>
		<td class="AffProduits">Nom du produit</td>
		<td class="AffProduits">Image</td>
		<td class="AffProduits">Quantit&eacute; restante en stock</td>
	</tr>
	<c:forEach items="${ListP}" var="p">
	<tr class="AffProduits">
		<td class="AffProduits">${p.idProduit}</td>
		<td class="AffProduits">${p.libProduit}</td>
		<td class="AffProduits"><img src="${p.img}" alt="${p.img}" width="200" height="200"></td>
		<td class="AffProduits">${p.quantite}</td>
	</tr>
	</c:forEach>
</table>
	
<br>
	
<!-- -------------- Bouton de retour -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/admin/GestionCategorie/">
	<input type="submit" value="Retour"/>
</form:form>
	
<br>
	
<!-- -------------- Bouton de déconnexion -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="D&eacute;connexion"/>
</form:form>

</body>
</html>

</body>
</html>