<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Surf&ampCo - Authentification</title>
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	
	<style>
		body {
			text-align: center;
		}
		h3,p {
			color: navy;
		}
	</style>
	
</head>

<header class="header">

  <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #a6ceea;">
  	<a class="navbar-brand" href="#" style="padding-left: 20px;">Company eCommerce</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span> </button> 
    <div class="collapse navbar-collapse" id="navbarText">
    	<ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#" style="padding-left: 40px;">Accueil</a>
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
    </div>
  </nav>

</header>

<body>

<div class="container">
    <div class="row">
        <div class="col-lg-3"> <img src="images\logo.PNG" alt="logo" width="175" height="122.5"> </div>
        <div class="col-lg-6">
          <div id="carousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carousel" data-slide-to="0" class="active"></li>
              <li data-target="#carousel" data-slide-to="1"></li>
              <li data-target="#carousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="images\slider1.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="images\slider2.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="images\slider3.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
        </div>
        <div class="col-lg-3"> 
          <nav class="navbar navbar-light bg-light">
            <form class="form-inline">
              <input class="form-control mr-sm-2" type="search" placeholder="Chercher un produit" aria-label="Search">
              <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Rechercher</button>
            </form>
          </nav>  
        </div>
    </div>
</div>

<h3> Inscription </h3>

<p>Entrez vos informations</p>

<form:form action="${pageContext.request.contextPath}/AjouterUser" method="post" modelAttribute="utilisateur">
<table>
  <tr>
    <td>Nom :</td>
    <td><form:input type="text" path="nom"/></td>
  </tr>
  <tr>
    <td>Pr&eacute;nom :</td>
    <td><form:input type="text" path="prenom"/></td>
  </tr>
  <tr>
    <td>Date de naissance :</td>
    <td><form:input type="text" path="dateNaissance"/></td>
  </tr>
  <tr>
    <td>Login : </td>
    <td><form:input type="text" path="login"/></td>
  </tr>
  <tr>
    <td>Password : </td>
    <td><form:input type="text" path="password"/></td>
  </tr>
  <tr>
    <td>Role : </td>
    <td>
      <form:select path="role">
        <c:forEach items="${ListR}" var="r">
		      <option value="${r.idRole}">${r.libRole}</option>
        </c:forEach>
		  </form:select>
    </td>
  </tr>
</table>
<input type="submit" value="Valider"/>
</form:form>

<!-- -------------- Bouton de retour -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/afficherlogin">
    <input type="submit" value="Retour"/>
</form:form>

</body>
</html>