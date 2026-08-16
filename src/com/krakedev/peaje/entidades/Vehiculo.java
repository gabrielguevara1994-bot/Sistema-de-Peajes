package com.krakedev.peaje.entidades;

public class Vehiculo {
	
	private String placa;
	private String tipo;
	private Conductor propietario;
	private tagElectronico tag;
	
	public Vehiculo(String placa) {
		this.placa = placa;
		tipo="L";
	}
	
	public void imprimir() {

		System.out.println("Placa: " + placa);
		System.out.println("Tipo: " + tipo);
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Conductor getPropietario() {
		return propietario;
	}

	public void setPropietario(Conductor propietario) {
		this.propietario = propietario;
	}

	public tagElectronico getTag() {
		return tag;
	}

	public void setTag(tagElectronico tag) {
		this.tag = tag;
	}
	
	

}
