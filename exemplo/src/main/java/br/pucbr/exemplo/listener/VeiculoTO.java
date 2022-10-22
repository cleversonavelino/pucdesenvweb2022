package br.pucbr.exemplo.listener;

import java.io.Serializable;

public class VeiculoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String placa;

	private Integer guidUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getGuidUsuario() {
		return guidUsuario;
	}

	public void setGuidUsuario(Integer guidUsuario) {
		this.guidUsuario = guidUsuario;
	}

}
