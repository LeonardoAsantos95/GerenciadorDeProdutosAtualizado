<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="service.ProdutoService"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="model.Produto" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
</head>
<body>

	${requestScope.mensagem } <br><br>
	${requestScope.mensagemeexcluir } <br><br>
	
	<h1>Lista de Produtos</h1>
	
	<a href="cadastro.jsp">Cadastrar novo produto</a> <br><br>
	
	<table border="1">
		<tr>
			<th>Codigo</th>
			<th>Nome</th>
			<th>Descricao</th>
			<th>Valor</th>
			<th>Estoque</th>	
		</tr>
			
		<%
			ArrayList<Produto> lista;
			ProdutoService ps = new ProdutoService();
			lista = ps.listaProduto();
			
			for (Produto p : lista) {		
		%>
		
		<tr>
			<td><%= p.getCodigo() %></td>
			<td><%= p.getNome() %></td>
			<td><%= p.getDescricao() %></td>
			<td><%= p.getValor() %></td>
			<td><%= p.getEstoque() %></td>
			<td><a href="alterar.jsp?codigo=<%=p.getCodigo()%>">Alterar</a></td>
			<td><a href="excluir.jsp?codigo=<%=p.getCodigo()%>">Excluir</a></td>
		</tr>
		
		<% 
		} 
		%>
	</table>
		
</body>
</html>