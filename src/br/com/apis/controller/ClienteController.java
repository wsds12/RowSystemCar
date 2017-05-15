package br.com.apis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.postgresql.jdbc2.ArrayAssistantRegistry;

import br.com.apis.entidades.Cliente;
import br.com.apis.jbdc.ClienteDAO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet({ "/UsuarioController", "/clicontroller.do" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClienteController() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ClienteDAO clienteDAO = new ClienteDAO();
	    List<Cliente> lista = clienteDAO.buscarTodos();
		
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id = request.getParameter("txtid");
		String nome= request.getParameter("txtnome");
		String login= request.getParameter("txtlogin");
		String senha= request.getParameter("txtsenha");
		String telefone1= request.getParameter("txttelefone1");
		String telefone2= request.getParameter("txttelefone2");
		String cidade= request.getParameter("txtcidade");
		String bairro= request.getParameter("txtbairro");
		String rua= request.getParameter("txtrua");
		String numero= request.getParameter("txtnumero");
		String uf= request.getParameter("txtuf");
		
	    Cliente cliente = new Cliente();
	    
	    if(id != ""){
	    	cliente.setId(Integer.parseInt(id));
	    }
	    
	    cliente.setNome(nome);
	    cliente.setLogin(login);
	    cliente.setSenha(senha);
	    cliente.setTelefone1(telefone1);
	    cliente.setTelefone2(telefone2);    
	    cliente.setCidade(cidade);
	    cliente.setBairro(bairro);
	    cliente.setRua(rua);
	    cliente.setNumero(numero);
	    cliente.setUf(uf);
	    
		ClienteDAO   clienteDAO= new ClienteDAO();
        clienteDAO.salvar(cliente);
		
	}

}
