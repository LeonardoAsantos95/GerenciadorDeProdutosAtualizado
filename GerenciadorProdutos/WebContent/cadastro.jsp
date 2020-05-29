<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrando Produto</title>
</head>
<body>

	${ requestScope.mensagem }

	<form action="controller.do" method="post">
		<input type="hidden" name="command" value="CadastrarProduto">
		Codigo: <input type="number" name="codigo_produto"> <br><br>
		Nome: <input type="text" name="nome_produto"> <br><br>
		Descrição:<input type="text" name="descricao_produto"> <br><br>
		Valor: <input type="number" step="0.1" name="valor_produto"> <br><br>
		Estoque: <input type="number" name="estoque_produto"> <br><br>
		<input type="submit" value="Cadastrar"> <br><br>
		<a href="listar.jsp">Ir para lista de produtos.</a>
	</form>

</body>
</html>