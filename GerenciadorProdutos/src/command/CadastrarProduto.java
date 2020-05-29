package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class CadastrarProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recebendo os parametros:		
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		String nome = request.getParameter("nome_produto");
		String descricao = request.getParameter("descricao_produto");
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		double valor = Double.parseDouble(request.getParameter("valor_produto")); 
		
		//Instaciando e popularum JavaBean de Produto:	
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
		
		//Instaciando uma Service:
		ProdutoService produtoService = new ProdutoService();
		
		//Solicitandp à service que registre o produto no banco:
		produtoService.cadastrar(produto);
		
		//Antes despachar o usuario, adicionar um atributo à requisição:
		request.setAttribute("mensagem", "O produto foi cadastrado com sucesso!");
		//Despachar o usuario à parte de visão(apresentação - view):
		RequestDispatcher view = request.getRequestDispatcher("cadastro.jsp");
		view.forward(request, response);
		
	}
}
