<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout repas</title>
</head>
<body>
	<h1>AJOUT</h1>

	<form action="./Traitement" method="POST">
		<label>Date</label> <input type="LocalDate" name="date" /> <br>
		<label>Heure</label><input type="LocalTime" name="heure" />  <br>
		<label>Repas</label> <input type="text" name="repas" /> <br>

		<button name="tache">Valider</button>
		<button name="tache">Annuler</button>
	</form>


</body>
</html>