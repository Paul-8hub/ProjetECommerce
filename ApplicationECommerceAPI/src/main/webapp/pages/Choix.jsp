<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Surf&ampCo - Choix</title>
	<style>
		h2 {
			text-align: center;
			color: navy;
		}
		body {
    		background-color: Wheat;
    		font-family:Arial, Helvetica, sans-serif;
		}
		.boutonsPages {
			text-align: center;
		}
	</style>
</head>
<body>

<!--<sec:authorize access="hasAuthority('Admin')">
	<h2>Bonjour admin</h2> 
</sec:authorize>-->

<h2>Bonjour ${u.prenom} ${u.nom}</h2>

<form:form action="/admin/GestionProduit/" method="post" class="boutonsPages">
    <input type="submit" value="Gestion Produits"/>
</form:form>

<br>

<form:form action="/admin/GestionCategorie/" method="post" class="boutonsPages">
    <input type="submit" value="Gestion Cat&eacute;gories"/>
</form:form>

<br>

<form action="/admin/AfficherCommande" method="post" class="boutonsPages">
    <input type="submit" value="Liste des commandes" />
</form>

<br>

<!-- -------------- Bouton de déconnexion -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="Deconnexion"/>
</form:form>

</body>
</html>