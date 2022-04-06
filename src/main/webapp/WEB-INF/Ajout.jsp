<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>Ajout repas</title>
</head>
<body>
<div class="container text-center">
	<h1>AJOUT</h1>

	<p class="message-confirmation">${messageConfirmation}</p>
	<p class="message-erreur">${messageErreur}</p>

	<form action="./AjoutRepas" method="POST">
		<label>Date</label> <input type="text" name="date" /> <br>
		<label>Heure</label><input type="text" name="heure" />  <br>
		<label>Repas</label> <textarea id="ingredients" name="ingredients" row="5" col="30"> Liste des ingrédients</textarea><br>

		<button name="valider"  type="submit" class="btn btn-success" >Valider</button>
	</form>
	<form action="./Retour" method="GET">
		<button name="annuler" type="submit" class="btn btn-warning">Annuler</button>
	</form>
	</div>
</body>
</html>