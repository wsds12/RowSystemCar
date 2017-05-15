package br.com.apis.autentificacao;

public class Login {
	private Integer id_log;
	private String Usuario;
	private String senha;
	public Integer getId_log() {
		return id_log;
	}
	public void setId_log(Integer id_log) {
		this.id_log = id_log;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
