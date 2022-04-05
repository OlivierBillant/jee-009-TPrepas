<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" />
<title>Ajout repas</title>
</head>
<body>
	<h1>AJOUT</h1>

	<p class="message-confirmation">${messageConfirmation}</p>

	<form action="./AjoutRepas" method="POST">
		<label>Date</label> <input type="text" name="date" /> <br>
		<label>Heure</label><input type="text" name="heure" />  <br>
		<label>Repas</label> <textarea id="ingredients" name="ingredients" row="5" col="30"> Liste des ingrédients</textarea><br>

		<button name="valider">Valider</button>
	</form>
	<form action="./Retour" method="GET">
		<button name="annuler">Annuler</button>
	</form>

</body>
</html>