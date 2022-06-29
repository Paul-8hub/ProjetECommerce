<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
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

<form:form action="${pageContext.request.contextPath}/admin/GestionProduit/ModifierProduit" method="post" enctype="multipart/form-data" modelAttribute="produitM">
<h3> Modifiez un produit </h3>
<form:input type="hidden" path="idProduit"/>
<table>
<tr>
	<td><form:label path="libProduit">Nom du produit :</form:label> </td>
	<td><form:input type="text" path="libProduit"/></td>
</tr>
<tr>
	<td><form:label path="img">Image du produit :</form:label> </td>
	<td><input type="file" name="file"/></td> <!-- Comment conserver image à travers modification -->
</tr>
<tr>
	<td><form:label path="quantite">Quantit&eacute; disponible :</form:label> </td>
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
<input type="submit" value="Valider"/>
</form:form>

<br>

<!-- -------------- Bouton de retour -------------- -->
<form:form method="post" action="${pageContext.request.contextPath}/admin/GestionProduit/">
    <input type="submit" value="Retour"/>
</form:form>

</body>
</html>