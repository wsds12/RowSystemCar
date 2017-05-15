 package br.com.apis.jbdc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.apis.entidades.*;
import br.com.apis.autentificacao.*;

public class ClienteDAO extends Cliente {

	private Connection conexao = Conexao.getConnection();

	public void cadastrar(Cliente cliente) {

		String consultasql = "INSERT INTO cliente (nome,login,senha,telefone1,telefone2,cidade,bairro,rua,numero,uf)  VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getLogin());
			preparador.setString(3, cliente.getSenha());
			preparador.setString(4, cliente.getTelefone1());
			preparador.setString(5, cliente.getTelefone2());
			preparador.setString(6, cliente.getCidade());
			preparador.setString(7, cliente.getBairro());
			preparador.setString(8, cliente.getRua());
			preparador.setString(9, cliente.getNumero());
			preparador.setString(10,cliente.getUf());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar!" + e.getMessage());
		}

	}

	public void alterar(Cliente cliente) {
		String consultasql = "update cliente set telefone1=?,telefone2=?, cidade=?, bairro=?, rua=?, numero=?, uf=?  WHERE id=?";

		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
            
			
			preparador.setString(1, cliente.getTelefone1());
			preparador.setString(2, cliente.getTelefone2());
			preparador.setString(3, cliente.getCidade());
			preparador.setString(4, cliente.getBairro());
			preparador.setString(5, cliente.getRua());
			preparador.setString(6, cliente.getNumero());
			preparador.setString(7, cliente.getUf());
			preparador.setInt(8,    cliente.getId());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Erro ao Alterar!" + e.getMessage());
		}
	}
	
	public void salvar(Cliente cliente) {
		
		if(cliente.getId() != null){
    	   alterar(cliente);
       }else{
    	   cadastrar(cliente);
       }
	}

	public void excluir(Cliente cliente) {
		String consultasql = "DELETE FROM cliente WHERE id=?";
		try {
			PreparedStatement preparador = conexao.prepareStatement(consultasql);
			preparador.setInt(1, cliente.getId());
			preparador.execute();
			preparador.close();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "id não existe!" + e.getMessage());
		}
	}

	public List<Cliente> buscarTodos() {
		String sql = "SELECT *FROM cliente ";
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setTelefone1(resultado.getString("telefone1"));
				lista.add(cliente);

			}

			preparador.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha na busca!" + e.getMessage());
		}
		return lista;
	}

	public Cliente buscarPorTelefone(String telefone1) {

		String sql = "SELECT * FROM cliente WHERE TELEFONE1=?";
		Cliente cliente = null;
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, telefone1);
			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()) { // se foi para proximo
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setTelefone1(resultado.getString("telefone1"));
			}

		} catch (SQLException e) {
			System.out.println("falha na busca");
		}
		return cliente;

	}

	public Cliente autentificar(Cliente cliente) {

		String sql = "SELECT * FROM cliente WHERE usuario = ? AND senha = ?";
		Cliente clienteRetorno = null;
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setObject(1, cliente.getLogin());
			preparador.setObject(2, cliente.getSenha());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) { // se foi para proximo
				clienteRetorno = new Cliente();
				clienteRetorno.setId(resultado.getInt("id"));
				clienteRetorno.setNome(resultado.getString("nome"));
				clienteRetorno.setLogin(resultado.getString("login"));
				clienteRetorno.setSenha(resultado.getString("senha"));
			}

		} catch (SQLException e) {
			System.out.println("falha na autenficação!");
		}
		return clienteRetorno;

	}
	
	

}
