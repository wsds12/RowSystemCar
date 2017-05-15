package br.com.apis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apis.entidades.Cliente;
import br.com.apis.jbdc.ClienteDAO;



@WebServlet("/excclientecontroller.do")
public class ExcClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExcClienteController() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("txtid");
		
		
		Cliente cliente= new Cliente();
		
		 if(id != ""){
		    	cliente.setId(Integer.parseInt(id));
		 }
		
	    ClienteDAO clienteDAO = new ClienteDAO();
	    clienteDAO.excluir(cliente);
	}

}
