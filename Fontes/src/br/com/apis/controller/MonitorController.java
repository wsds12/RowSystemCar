package br.com.apis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.apis.entidades.Monitor;
import br.com.apis.jbdc.MonitorDAO;


@WebServlet({ "/MonitorController", "/monicontroller.do" })
public class MonitorController extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
   
    public MonitorController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	    Monitor monitor = new Monitor();
	    monitor.setNome(nome);
	    monitor.setLogin(login);
	    monitor.setSenha(senha);
	    monitor.setTelefone1(telefone1);
	    monitor.setTelefone2(telefone2);    
	    monitor.setCidade(cidade);
	    monitor.setBairro(bairro);
	    monitor.setRua(rua);
	    monitor.setNumero(numero);
	    monitor.setUf(uf);
		MonitorDAO   monitorDAO= new MonitorDAO();
		monitorDAO.cadastrar(monitor);
	}

}
