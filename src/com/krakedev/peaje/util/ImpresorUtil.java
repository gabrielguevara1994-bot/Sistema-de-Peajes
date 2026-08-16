package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.entidades.tagElectronico;

public class ImpresorUtil {
	
	public void imprimirVehiculo(Vehiculo vehiculo) {
		Conductor c1= new Conductor();
		c1.imprimir();
		tagElectronico tag1= new tagElectronico();
		tag1.imprimir();
		Vehiculo v1= new Vehiculo();
		v1.imprimir();
		
	}

}
