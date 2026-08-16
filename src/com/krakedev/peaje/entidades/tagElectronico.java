package com.krakedev.peaje.entidades;

public class tagElectronico {
	
	private String idTag;
	private double saldo;
	private boolean activo;
	
	public tagElectronico() {
	}
	
	public tagElectronico(String idTag) {
		this.idTag = idTag;
		saldo=0.0;
		activo=true;
	}
	public String getIdTag() {
		return idTag;
	}
	public void setIdTag(String idTag) {
		this.idTag = idTag;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void imprimir() {

		System.out.println("Número de TAG: " + idTag);
		System.out.println("Saldo: " + saldo);
		System.out.println("Activo: " + activo);
		
	}
	
	

}
