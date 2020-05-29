package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class ListarProdutos implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//solicitar à servicea lista de produtos:
		ProdutoService produtoService = new ProdutoService();
		
		//Instanciando a lista um lista de produtos (vazia):
		ArrayList<Produto> listaProduto = null;
		
		//Carregando a lista com os professores do banco de dados:
		listaProduto = produtoService.listaProduto();
		
		//Despachar o usuario à parte de visão(apresentação - view):
		RequestDispatcher view = request.getRequestDispatcher("listar.jsp");
		view.forward(request, response);
		
	}

}
