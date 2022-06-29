<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>

<title>Surf&ampCo - Accueil</title>

<meeta name ="author" content="Paul Gaillard"></meeta>

<style>
  body {
			text-align: center;
	}
	h2,h3,p {
		color: navy;
	}
  div {
		text-align: center;
  }
  table,tr,td {
		border: 1px solid;
		text-align: center;
	}
	table {
		border-collapse: collapse;
	}
</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>

<header class="header">

  <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #a6ceea;">
        <a class="navbar-brand" href="#" style="padding-left: 20px;">SurfShop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="${pageContext.request.contextPath}/client/" style="padding-left: 40px;">Accueil</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" style="padding-left: 40px;">Produits</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" style="padding-left: 40px;">Cat&#233gories</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" style="padding-left: 40px;">Panier</a>
            </li>
          </ul>
         <form:form method="post" action="${pageContext.request.contextPath}/logout" class="form-inline">
    		<button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Se d&#233connecter</button>
  		</form:form>
        </div>
    </nav>

</header>

<body>

<h2>Panier</h2>

<table>
  <tr>
    <td>Produit s&eacute;lectionn&eacute;s</td>
    <td>Quantit&eacute;</td>
    <td></td>
    <td></td>
  </tr>
  <c:forEach items="${ListLP}" var="lp">
    <tr>
      <td>
        ${lp.produit.libProduit}
        <img src="${lp.produit.img}" alt="${p.img}" width="200" height="200">
      </td>
      <td>${lp.quantite}</td>
      <td><a href="SupprimerLigne?id=${lp.idLignePanier}">Supprimer</a></td>
      <td>
        <form:form action="ModifierLigne" method="post">
          <input type="hidden" name="idLignePanier" value="${lp.idLignePanier}"/>
          <input type="number" name="quantite" value="Quanti&eacute;"/> <br>
          <input type="submit" value="Modifier la quantit&eacute;"/>
        </form:form>
      </td>
    </tr>
  </c:forEach>
</table>

<br>

<!-- -------------- Bouton de commande -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/client/Commander/">
    <input type="submit" value="Commander les articles"/>
</form:form>

<br>

<!-- -------------- Bouton de retour -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/client/">
    <input type="submit" value="Retour"/>
</form:form>

</body>

<footer>
  <div class="text-center text-dark p-3" style="background-color: #a6ceea;">
    2022 Copyright : SurfShop
  </div>
</footer>
</html>