package com.krakedev.peaje.test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.entidades.tagElectronico;
import com.krakedev.peaje.servicios.EstacionPeaje;
import com.krakedev.peaje.util.ImpresorUtil;

public class TestVehiculo {

	public static void main(String[] args) {
	
		Conductor conductor1 = new Conductor("1712345678", "Gabriel", "Endara");

	
		Vehiculo vehiculo1 = new Vehiculo("PBC-1234");
		vehiculo1.setTipo("L");

		
		tagElectronico tag1 = new tagElectronico("TAG-001");

		vehiculo1.setPropietario(conductor1);
		vehiculo1.setTag(tag1);

	
		System.out.println("--- Impresión propia del Vehículo ---");
		vehiculo1.imprimir();
		System.out.println();

	
		System.out.println("--- Impresión con ImpresorUtil ---");
		ImpresorUtil.imprimirVehiculo(vehiculo1);
		System.out.println();

	
		EstacionPeaje estacion = new EstacionPeaje();

		
		System.out.println("Recargando $10.00 al TAG-001...");
		boolean recarga = estacion.recargarTag(vehiculo1.getTag(), 10.0);
		System.out.println("Recarga exitosa: " + recarga);

	
		System.out.println("Cobrando peaje liviano ($1.00)...");
		boolean cobro = estacion.cobrarPeaje(vehiculo1);
		System.out.println("Cobro exitoso: " + cobro);


		Conductor conductor2 = new Conductor("1787654321", "Maria", "Lopez");
		Vehiculo vehiculo2 = estacion.registrarVehiculo("PDF-9876", "P", conductor2, "TAG-002");


		System.out.println("Transfiriendo $4.00 del TAG-001 al TAG-002...");
		boolean transferencia = estacion.transferirSaldoTag(vehiculo1.getTag(), vehiculo2.getTag(), 4.0);
		System.out.println("Transferencia exitosa: " + transferencia);
		System.out.println();

	
		System.out.println("=== ESTADO FINAL VEHÍCULO 1 ===");
		ImpresorUtil.imprimirVehiculo(vehiculo1);

		System.out.println("=== ESTADO FINAL VEHÍCULO 2 ===");
		ImpresorUtil.imprimirVehiculo(vehiculo2);
	}
}