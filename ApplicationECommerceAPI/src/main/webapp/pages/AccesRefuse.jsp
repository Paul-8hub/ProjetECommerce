<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Spring - Acc&egrave;s refus&eacute;</title>
</head>
<body>

Vous n'avez pas le droit d'acc&eacute;der &agrave; cette page.

<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="Deconnexion"/>
	</form:form>

</body>
</html>