<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="service.ProdutoService"%>
    <%@ page import="model.Produto" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Excluindo</title>
</head>
<body>

		<%
	
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ProdutoService produtoService = new ProdutoService();
		Produto p = produtoService.consultar(codigo);
	
		%>
		
	<form action="controller.do" method="post">
		<input type="hidden" name="command" value="ExcluirProduto">
		Codigo: <input type="number" name="codigo_produto" readonly="true" value="<%=p.getCodigo()%>"> <br><br>
		Nome: <input type="text" name="nome_produto" readonly="true" value="<%=p.getNome()%>"> <br><br>
		Descrição:<input type="text" name="descricao_produto" readonly="true" value="<%=p.getDescricao()%>"> <br><br>
		Valor: <input type="text" step="0.1" name="valor_produto" readonly="true" value="<%=p.getValor()%>"> <br><br>
		Estoque: <input type="text" name="estoque_produto" readonly="true" value="<%=p.getEstoque()%>"> <br><br>
		<input type="submit" value="Excluir">
	</form>
	
	<br><br><a href="listar.jsp">Voltar à lista.</a>

</body>
</html>