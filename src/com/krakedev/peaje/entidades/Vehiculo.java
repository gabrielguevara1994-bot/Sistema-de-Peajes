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
	
	

}
