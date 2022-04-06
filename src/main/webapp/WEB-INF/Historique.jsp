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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Historique</title>
</head>
<body>
	<div class="container text-center">
		<h1>Historique</h1>
	</div>


	<div class="container text-center w-50">

		<table class="table table-bordered" >
			<thead class="table-dark">
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
					<c:if test="${listeIngredient.size()> 0 && param.id==repas.identifiant}">
						<tr>
							<td colspan="3"><c:forEach var="ingredient" items="${listeIngredient}">
									<ul>
										<li>${ingredient}</li>
									</ul>
								</c:forEach></td>
						</tr>
					</c:if>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
	<div class="text-center">
		<div class="text-center btn-group" role="group"
			aria-label="Basic example">
			<form action="./AjoutRepas" method="GET">
				<button type="submit" class="btn btn-success mx-3">Ajouter un
					nouveau repas</button>
			</form>
			<form action="./Retour" method="GET">
				<button name="annuler" type="submit" class="btn btn-warning">Annuler</button>
			</form>
		</div>
	</div>
	
</body>
</html>