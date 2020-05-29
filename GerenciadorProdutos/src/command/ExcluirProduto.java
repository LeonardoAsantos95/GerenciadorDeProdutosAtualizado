package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class ExcluirProduto implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//captura de parametros: Produto para ser excluido do banco:
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));	
	
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		
		ProdutoService produtoservice = new ProdutoService();		
		produtoservice.excluir(produto);
		
		request.setAttribute("mensagemeexcluir", "Produto foi excluido com sucesso!");
		
		RequestDispatcher view = request.getRequestDispatcher("listar.jsp");
		view.forward(request, response);
		
	}
}
