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
        <!-- <form action="Authentification.jsp" class="form-inline">
    		<button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Se connecter</button>
  		</form> -->
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

<h3> Se connecter </h3>

<p>Entrez votre login et mot de passe</p>

<form:form action="${pageContext.request.contextPath}/traiterAuth" method="post">
Login :
<input type="text" name="username"/> <br>
Mot de passe :
<input type="password" name="password"/> <br>
<br>
<input type="submit" value="Valider"/>
</form:form>

<c:if test="${param.error!=null}">
  <br>
  Le nom d'utilisateur ou le mot de passe est incorrect.
  <br>
</c:if>

<c:if test="${param.logout!=null}">
	<br>
  Vous &ecirc;tes d&eacute;connect&eacute;.
  <br>
</c:if>

<br>

<!-- Ajouter un utilisateur -->
<form:form method="post" action="${pageContext.request.contextPath}/Inscription">
    <input type="submit" value="Ajouter un utilisateur"/>
</form:form>

</body>
</html>