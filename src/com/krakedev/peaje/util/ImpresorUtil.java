package com.krakedev.peaje.util;

import com.krakedev.peaje.entidades.Vehiculo;

public class ImpresorUtil {
	
	public void imprimirVehiculo(Vehiculo vehiculo) {
		if(vehiculo!=null) {
			System.out.println("=== INFORMACIÓN DEL VEHÍCULO ===");
			vehiculo.imprimir();
			
			
		if(vehiculo.getPropietario()!=null) {
			System.out.println("=== INFORMACIÓN DEL CONDUCTOR ===");
			vehiculo.getPropietario().imprimir();
			
		if(vehiculo.getTag()!=null) {
			System.out.println("=== INFORMACIÓN DEL TAG ===");
			vehiculo.getTag().imprimir();
		}
		}
		}
		
		
	}

}
