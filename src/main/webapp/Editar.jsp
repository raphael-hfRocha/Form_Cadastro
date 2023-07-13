
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar usuario</title>
</head>

<body>
	<div class="container-fluid text-center">
		<h1>Editar usuário</h1>
	</div>

	<div class="container">
		<form name="frmCadastro" action="update"
			style="max-width: 500px; margin: 0 auto;">
			<div class="form-group">
				<input type="text" name="id_user" class="form-control" readonly
					value="<%out.print(request.getAttribute("id_user"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputNome1">Nome:</label> <input type="text"
					name="nome" class="form-control" placeholder="Nome"
					value="<%out.print(request.getAttribute("nome"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputSobrenome1">Sobrenome:</label> <input
					type="text" name="sobrenome" class="form-control"
					placeholder="Sobrenome"
					value="<%out.print(request.getAttribute("sobrenome"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">E-mail:</label> <input type="email"
					name="email" class="form-control" placeholder="E-mail"
					value="<%out.print(request.getAttribute("email"));%>">
			</div>
			<div class="form-group">
				<label for="exampleInputSenha1">Senha:</label> <input
					type="password" name="senha" class="form-control"
					placeholder="Senha"
					value="<%out.print(request.getAttribute("senha"));%>">
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary" onclick="validar()">Salvar</button>
			</div>
			<!--<button type="button" class="btn btn-secondary m-2" onclick="cancelForm()">Cancelar</button> -->
		</form>
	</div>

	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
	<script src="scripts/Validador.js"></script>

</body>

</html>