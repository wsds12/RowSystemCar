package br.com.apis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apis.entidades.Cliente;
import br.com.apis.jbdc.ClienteDAO;

/**
 * Servlet implementation class AlterarClienteController
 */
@WebServlet("/altclicontroller")
public class AlterarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AlterarClienteController() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String telefone1= request.getParameter("txttelefone1");
		String telefone2= request.getParameter("txttelefone2");
		String cidade= request.getParameter("txtcidade");
		String bairro= request.getParameter("txtbairro");
		String rua= request.getParameter("txtrua");
		String numero= request.getParameter("txtnumero");
		String uf= request.getParameter("txtuf");
		
	    Cliente cliente = new Cliente();
	    
	  
	    cliente.setTelefone1(telefone1);
	    cliente.setTelefone2(telefone2);    
	    cliente.setCidade(cidade);
	    cliente.setBairro(bairro);
	    cliente.setRua(rua);
	    cliente.setNumero(numero);
	    cliente.setUf(uf);
	    
		ClienteDAO   clienteDAO= new ClienteDAO();
        clienteDAO.alterar(cliente);
	}

}
