<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/telephone.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<nav class="navbar navbar-light bg-light">
	  <div class="container-fluid">
	    <h1>Agenda de contatos</h1>
	    <a href="novo.html" class="btn btn-success">Novo CONTATO</a>
	  </div>
	</nav>
	<div class="table-responsive">
		
		
		<table class="table  table-striped mx-auto">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Fone</th>
					<th scope="col">Email</th>
					<th scope="col">Opções</th>
				</tr>
			</thead>
			<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
				<tr>
					<th><%=lista.get(i).getIdcont()%></th>
					<th><%=lista.get(i).getNome()%></th>
					<th><%=lista.get(i).getFone()%></th>
					<th><%=lista.get(i).getEmail()%></th>
					<td><a href="select?idcont=<%=lista.get(i).getIdcont()%>" class="btn btn-warning">Atualizar</a>
						<a href="javascript: confirmar(<%=lista.get(i).getIdcont()%>)" class="btn btn-danger">Excluir</a>
					</td>
				</tr>
			 <%} %>
			</tbody>
		</table>
	</div>
	<script src="scripts/confirmador.js"></script>
</body>
</html>