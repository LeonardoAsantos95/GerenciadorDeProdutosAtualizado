package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;



@WebServlet("/controller.do")
public class ServeltsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirecionando o tratamento da requisi��o para o metodo doExecute:
		doExecute(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Redirecionando o tratamento da requisi��o para o metodo doExecute:
		doExecute(request, response);
		
	}
	
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//Descobrir qual comando deve ser executado:
			String comando = request.getParameter("command");
			//Declarando um command:
			Command command = (Command) Class.forName("command." + comando).newInstance();
			//Solicitar a execu��o da a��o do comando:
			command.execute(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
