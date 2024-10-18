<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Editar Contato</title>
<link rel="icon" href="imagens/telephone.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="estilo.css">
</head>
<body>

	<nav class="navbar navbar-light bg-light">
	  <div class="container-fluid">
	    <h1>Edição de contato</h1>
	    <a href="main" class="btn btn-success">Home</a>
	  </div>
	</nav>
	
	<div class="container mx-auto">
		<form name="formContato" action="update" onsubmit="return validarFormulario()" class="w-75">
		  <div class="mb-3">
		    <label class="form-label">ID</label>
		    <input type="text" name="idcon" readonly value="<%out.print(request.getAttribute("idcont"));%>" class="form-control">
		  </div>
		  <div class="mb-3">
		    <label class="form-label">Nome</label>
		    <input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>" class="form-control">
		  </div>
		  <div class="mb-3">
		    <label class="form-label">Fone</label>
		    <input type="text" name="fone" maxlength="11" value="<%out.print(request.getAttribute("fone"));%>" class="form-control">
		  </div>
		  <div class="mb-3">
		    <label class="form-label">Email</label>
		    <input type="email" name="email" value="<%out.print(request.getAttribute("email"));%>" class="form-control">
		  </div>		
				
		  <input type="submit" value="Salvar" class="btn btn-success">
		</form>
	</div>
		
	<script src="scripts/validador.js"></script>
</body>
</html>