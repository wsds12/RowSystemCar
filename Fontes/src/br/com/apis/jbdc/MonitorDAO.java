package br.com.apis.jbdc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.apis.entidades.Monitor;
import br.com.apis.entidades.Monitor;

public class MonitorDAO {
	private Connection conexao = Conexao.getConnection();
	
	public void cadastrar(Monitor monitor) {

		String consultasql = "INSERT INTO monitor (nome,login,senha,telefone1,telefone2,cidade,bairro,rua,numero,uf)  VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);// cria
																					// a
																					// consulta
			preparador.setString(1, monitor.getNome());
			preparador.setString(2, monitor.getLogin());
			preparador.setString(3, monitor.getSenha());
			preparador.setString(4, monitor.getTelefone1());
			preparador.setString(5, monitor.getTelefone2());
			preparador.setString(6, monitor.getCidade());
			preparador.setString(7, monitor.getBairro());
			preparador.setString(8, monitor.getRua());
			preparador.setString(9, monitor.getNumero());
			preparador.setString(10, monitor.getUf());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!" + e.getMessage());
		}

	}
	
	private void alterar(Monitor monitor) {
		
		String consultasql = "UPDATE monitor SET nome=?,login=?, senha=?, telefone1,cidade bairro=?, rua=?, numero=?, uf=?  WHERE telefone1=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);// cria
			preparador.setString(1, monitor.getNome());
			preparador.setString(2, monitor.getLogin());
			preparador.setString(3, monitor.getSenha());
			preparador.setString(4, monitor.getTelefone1());
			preparador.setString(5, monitor.getTelefone2());
			preparador.setString(6, monitor.getCidade());
			preparador.setString(7, monitor.getBairro());
			preparador.setString(8, monitor.getRua());
			preparador.setString(9, monitor.getNumero());
			preparador.setString(10, monitor.getUf());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao Alterar!" + e.getMessage());
		}
		
	}
	
	public void excluir(Monitor monitor) {
		String consultasql = "DELETE FROM monitor WHERE telefone1=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setString(1, monitor.getTelefone1());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "telefone não existe!" + e.getMessage());
		}
	}
	public List<Monitor> buscarTodos() {
		String sql = "SELECT *FROM monitor ";
		List<Monitor> lista = new ArrayList<Monitor>();
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Monitor monitor = new Monitor();
				monitor.setId(resultado.getInt("id"));
				monitor.setNome(resultado.getString("nome"));
				monitor.setTelefone1(resultado.getString("telefone1"));
				lista.add(monitor);

			}

			preparador.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha na busca!" + e.getMessage());
		}
		return lista;
	}
	
	public Monitor buscarPorTelefone(String telefone1) {

		String sql = "SELECT * FROM monitor WHERE telefone1=?";
		Monitor monitor = null;
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, telefone1);
			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) { // se foi para proximo
				monitor = new Monitor();
				monitor.setId(resultado.getInt("id"));
				monitor.setNome(resultado.getString("nome"));
				monitor.setTelefone1(resultado.getString("telefone1"));
			}

		} catch (SQLException e) {
			System.out.println("falha na busca");
		}
		return monitor;

	}

}
