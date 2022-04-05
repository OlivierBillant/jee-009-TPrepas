<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@page import="java.util.ArrayList"%>
   <%@page import="model.bo.Repas"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" />

<title>Historique</title>
</head>
<body>
<h1>HISTORIQUE</h1>
		<table>
			<thead>
				<tr>
					<th colspan="1">Date</th>
					<th colspan="1">Heure</th>
					<th colspan="1">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="repas" items="${listeRepas}">

					<tr>
						<td>${repas.date}</td>
						<td>${repas.heure}</td>
						<td> <a href="./VisualiserRepas?id=${repas.identifiant}">Détail</a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	<form action="./AjoutRepas" method="GET">
		<button>Ajouter un nouveau repas</button>
	</form>

	<form action="./Retour" method="GET">
		<button name="annuler">Annuler</button>
	</form>
	
	<table>
			<tbody>
				<c:forEach var="ingredient" items="${listeIngredient}">
					<tr>
						<td>${ingredient.libelle}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>