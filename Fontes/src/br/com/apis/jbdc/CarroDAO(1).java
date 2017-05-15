package br.com.apis.jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.apis.entidades.*;

public class CarroDAO {
	private Connection conexao = Conexao.getConnection();
	private void cadastrar(Carro carro) {

		String consultasql = "inset into Carro (marca,modelo,cor,placa) values(?,?,?,?)";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);// cria
																					// a
																					// consulta
			preparador.setString(1, carro.getMarca());
			preparador.setString(2, carro.getModelo());
			preparador.setString(3, carro.getCor());
			preparador.setInt(4, carro.getPlaca());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com Suscesso!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!" + e.getMessage());
		}

	}
	private void alterar(Carro carro) {
		
		String consultasql = "update Carro set  cor=?, placa=?  WHERE placa=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setString(1, carro.getCor());
			preparador.setInt(2, carro.getPlaca());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "alterado com Sucesso!");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao alterar!" + e.getMessage());
		}
		
	}
	
	public void excluir(Carro carro) {
		String consultasql = "DELETE FROM Carro WHERE placa=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setInt(1, carro.getPlaca());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Carro não existe!" + e.getMessage());
		}
	}
}
