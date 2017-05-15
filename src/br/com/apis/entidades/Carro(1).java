package br.com.apis.entidades;

public class Carro {
	private Integer id;
	private String marca;
	private String modelo;
	private String cor;
    private Integer placa;
	public Integer getId_car() {
		return id;
	}
	public void setId_car(Integer id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Integer getPlaca() {
		return placa;
	}
	public void setPlaca(Integer placa) {
		this.placa = placa;
	}

}
