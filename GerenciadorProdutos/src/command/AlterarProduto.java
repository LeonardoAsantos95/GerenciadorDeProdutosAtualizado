package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class AlterarProduto implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recebendo os dados do usuario: (capturando os parametros)
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		String nome = request.getParameter("nome_produto");
		String descricao = request.getParameter("descricao_produto");
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		double valor = Double.parseDouble(request.getParameter("valor_produto"));
		
		
		ProdutoService produtoservice = new ProdutoService();
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
		produtoservice.alterar(produto);
		
		request.setAttribute("mensagem", "Os dados foram alterados com sucesso!");
		
		RequestDispatcher view = request.getRequestDispatcher("listar.jsp");
		view.forward(request, response);
	}
	

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		//Capturnado o codigo do produto que o usuario quer alterar:
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));

	
		//Solicitando à service os dados do produto do codigo informado:
		ProdutoService produtoService = new ProdutoService();
		
		//Solicitando  à service que consulte o produto no banco:
		Produto produto = produtoService.consultar(codigo);
		
		//Alterando produto:
		response.setContentType("text/html");
		
		// Recebendo os dados do usuario: (capturando os parametros)
		int cod = Integer.parseInt(request.getParameter("codigo_produto"));
		String nome = request.getParameter("nome_produto");
		String descricao = request.getParameter("descricao_produto");
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		double valor = Double.parseDouble(request.getParameter("valor_produto"));
		
		//Instaciando o objeto do tipo produto:
		Produto p = new Produto();
		p.setCodigo(cod);
		p.setNome(nome);
		p.setDescricao(descricao);
		p.setValor(valor);
		p.setEstoque(estoque);
		
		//Enviar para produto service:
		ProdutoService ps = new ProdutoService();
		ps.alterar(produto);
		
		//Antes despachar o usuario, adicionar um atributo à requisição:
		request.setAttribute("mensagem", "O produto foi alterado com sucesso!");
			
		//Despachar o usuario à parte de visão(apresentação - view):
		RequestDispatcher view = request.getRequestDispatcher("alterar.jsp?codigo=" + codigo);
		view.forward(request, response);
	}

}

*/
