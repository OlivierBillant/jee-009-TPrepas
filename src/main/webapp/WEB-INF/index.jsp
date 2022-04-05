<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des repas</title>
</head>
<body>

<h1>Accueil</h1>
	<form action="./AjoutRepas" method="GET">
		<button name="tache">Ajouter un nouveau repas</button>
	</form>

	<form action="./VisualiserRepas" method="GET">
		<button name="tache">Visualiser les repas</button>
	</form>
	
</body>
</html>