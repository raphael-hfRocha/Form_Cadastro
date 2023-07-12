<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("usuarios");

/* for(int i = 0; i < lista.size(); i++)
{
out.println(lista.get(i).getId_user());
out.println(lista.get(i).getNome());
out.println(lista.get(i).getSobrenome());
out.println(lista.get(i).getEmail());
out.println(lista.get(i).getSenha());
}  */
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Registro de cadastros</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Registro de cadastros</h1>

	<ul class="nav nav-pills">
		<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="Formulario.html" class="botao1">Novo registro</a>
		</li>
	</ul>
		<div>
			<table class="table table-bordered" style="margin-top: 60px;">
				<thead class="thead-dark">
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Sobrenome</th>
						<th>E-mail</th>
						<th>Senha</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getId_user()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getSobrenome()%></td>
						<td><%=lista.get(i).getEmail()%></td>
						<td><%=lista.get(i).getSenha()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>

		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
			crossorigin="anonymous">
</body>
</html>