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

<title>cgu</title>
</head>
<body>
<div class="my-5">
	<div class="card text-center w-25 mx-auto">
		<div class="card-body">
			<h1>CGU ?</h1>
			<form action="./CookiesServlet" method="POST">
				<button class="btn btn-success my-3 w-100" type="submit">Mmmok!</button>
			</form>

			<form action="./" method="GET">
				<button class="btn btn-danger w-100" type="submit">Meh...</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>