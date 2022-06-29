<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Surf&ampCo - Gestion Administrateur</title>
	
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
		
		.AffProduits {
			border: 1px solid;
			text-align: center;
		}
		
		table {
			border-collapse: collapse;
		}
	</style>

</head>
<body>

<h2> Gestion des produits </h2>

<form:form action="AjouterProduit" method="post" enctype="multipart/form-data" modelAttribute="produit">

<h3> Ajoutez un produit </h3>
<table>
<tr>
	<td>Nom du produit :</td>
	<td><form:input type="text" path="libProduit"/></td>
</tr>
<tr>
	<td>Image :</td>
	<td><input type="file" name="file"/></td>
</tr>
<tr>
	<td>Quantit&eacute; stock :</td>
	<td><form:input type="text" path="quantite"/></td>
</tr>
<tr>
	<td>Cat&eacute;gorie du produit :</td>
	<td><form:select path="categorie">
	<c:forEach items="${ListC}" var="c">
		<option value="${c.idCategorie}">${c.nomCategorie}</option>
	</c:forEach>
		</form:select></td>
</tr>
</table>
<input type="submit" value="Valider">
</form:form>
<br> 

<h3> Produits en vente </h3>

<!-- Tableau de produits -->
<table class="AffProduits">
	<tr class="AffProduits">
		<td class="AffProduits">idProduit</td>
		<td class="AffProduits">Nom du produit</td>
		<td class="AffProduits">Image</td>
		<td class="AffProduits">Quantit&eacute; restante en stock</td>
		<td class="AffProduits">Cat&eacute;gorie du produit</td>
		<td class="AffProduits"></td>
		<td class="AffProduits"></td>
	</tr>
	<c:forEach items="${ListP}" var="p">
	<tr class="AffProduits">
		<td class="AffProduits">${p.idProduit}</td>
		<td class="AffProduits">${p.libProduit}</td>
		<td class="AffProduits"><img src="${p.img}" alt="${p.img}" width="200" height="200"></td>
		<td class="AffProduits">${p.quantite}</td>
		<td class="AffProduits">${p.categorie.nomCategorie}</td>
		<td class="AffProduits"><a href="RedirigerProduit?id=${p.idProduit}">Modifier</a></td>
		<td class="AffProduits"><a href="SupprimerProduit?id=${p.idProduit}">Supprimer</a></td>
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
		<input type="submit" value="Deconnexion"/>
</form:form>

</body>
</html>