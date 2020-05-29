<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="service.ProdutoService"%>
    <%@ page import="model.Produto" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterando</title>
</head>
<body>

	<%
	
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ProdutoService produtoService = new ProdutoService();
		Produto p = produtoService.consultar(codigo);
	
	%>

	${ requestScope.mensagem }
	
	<form action="controller.do" method="post">
		<input type="hidden" name="command" value="AlterarProduto">
		Codigo: <input type="number" name="codigo_produto" readonly="true" value="<%=p.getCodigo()%>"> <br><br>
		Nome: <input type="text" name="nome_produto" value="<%=p.getNome()%>"> <br><br>
		Descrição:<input type="text" name="descricao_produto" value="<%=p.getDescricao()%>"> <br><br>
		Valor: <input type="number" step="0.1" name="valor_produto" value="<%=p.getValor()%>"> <br><br>
		Estoque: <input type="number" name="estoque_produto" value="<%=p.getEstoque()%>"> <br><br>
		<input type="submit" value="Alterar"> <br><br>
		<a href="listar.jsp">Voltar para lista de produtos.</a>
	</form>

</body>
</html>