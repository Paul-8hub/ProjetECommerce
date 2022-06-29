<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Surf&ampCo - Inscription</title>
	<style>
		h2 {
			text-align: center;
			color: navy;
		}
		h3 {
			color: navy;
		}		
		body {
    		background-color: Wheat;
    		font-family:Arial, Helvetica, sans-serif;
		}
	</style>
</head>
<body>

<h2>Ajout d'un utilisateur/Inscription</h2>

<form action="TraitementUser" method="get">
<table>
<tr>
	<td>Nom : </td>
	<td><input type="text" name="nomUser"></td>
</tr>
<tr>
	<td>Prénom : </td>
	<td><input type="text" name="prenomUser"></td>
</tr>
<tr>
	<td>Date de naissance (jj/mm/aaaa) : </td>
	<td><input type="text" name="dateNUser"></td>
</tr>
<tr>
	<td>Login : </td>
	<td><input type="text" name="login"></td>
</tr>
<tr>
	<td>Mot de passe : </td>
	<td><input type="password" name="mdp"></td>
</tr>
<tr>
	<td>Role (Administrateur ou Client): </td>
	<td><select name="idRole">
		<option value="1">Administrateur</option>
		<option value="2">Client</option>
	</select></td>
</tr>
</table>
<input type="submit" value="Valider">
</form>

<br>

<!-- -------------- Bouton de retour -------------- -->
<form action="TraitementCategorie">
    <input type="submit" value="Retour" />
</form>
</body>
</html>