package br.com.apis.jbdc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
    public static Connection getConnection(){ 
    	Connection conexao = null;
    	try {
    		Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BancoRowSystemCar","postgres","62536");
			System.out.println("conectou!");
		} catch (SQLException e) {
		    JOptionPane.showMessageDialog(null, "Erro de Conexão com o Banco de Dados!" + e.getMessage());
		
		}catch (ClassNotFoundException e) {
			 JOptionPane.showMessageDialog(null, "driver não encontrado!" + e.getMessage());
		}
		return conexao;
    }
}
