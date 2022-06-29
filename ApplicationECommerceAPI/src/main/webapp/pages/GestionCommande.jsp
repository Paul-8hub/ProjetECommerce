<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Surf&ampCo - Gestion des commandes</title>
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

<h2> Gestion des commandes </h2>

<br> 

<h3> Cat&eacute;gories existantes </h3>
<table class="AffCat">
	<tr class="AffCat">
		<td class="AffCat">Id ligne commande</td>
		<td class="AffCat">Id commande correspondante</td>
		<td class="AffCat">Nom du produit vendu</td>
		<td class="AffCat">Image du produit</td>
		<td class="AffCat">Quantite de produit vendu</td>
	</tr>
	<c:forEach items="${ListLC}" var="lc">
	<tr class="AffCat">
		<td class="AffCat">${lc.idLigneCommande}</td>
		<td class="AffCat">${lc.commande.idCommande}</td>
		<td class="AffCat">${lc.produit.libProduit}</td>
		<td class="AffCat"><img src="${lc.produit.img}" alt="${lc.produit.img}" width="200" height="200"></td>
		<td class="AffCat">${lc.quantite}</td>
		<td class="AffCat"><a href="SupprimerCommande?id=${lc.idLigneCommande}">Supprimer</a></td>
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