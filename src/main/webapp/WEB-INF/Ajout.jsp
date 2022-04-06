<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<title>Ajout repas</title>
</head>
<body>
	<div class="container text-center">
		<h1>Ajout</h1>

		<p class="message-confirmation">${messageConfirmation}</p>
		<p class="message-erreur">${messageErreur}</p>
	</div>
	<div class="container w-50">
		<div class="text-center my-3 mx-5 px-5 ">
			<form action="./AjoutRepas" method="POST">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Date</span>
					</div>
					<input type="text" name="date" class="form-control"
						placeholder="YYYY-MM-DD" aria-label="Date"
						aria-describedby="basic-addon1" />
				</div>
				<br>

				<div class="input-group mb-3">
					<div class="input-group-append">
						<span class="input-group-text" id="basic-addon1">Heure</span>
					</div>
					<input type="text" name="heure" class="form-control"
						placeholder="hh-mm-ss" aria-label="Heure"
						aria-describedby="basic-addon1" />
				</div>
				<br>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text h-100">Repas</span>
					</div>
					<textarea id="textarea" name="ingredients" row="5" col="30"
						placeholder="Ingrédient1,Ingrédient2,..." class="form-control"
						aria-label="With textarea"> </textarea>
				</div>
				<br>
				<div class="w-100">
					<button name="btn-valider" type="submit"
						class="btn btn-success my-s3 w-25">Valider</button>
					<a class="btn btn-warning w-25" href="./" role="button">Annuler</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>