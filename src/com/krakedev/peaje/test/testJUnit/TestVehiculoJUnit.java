package com.krakedev.peaje.test.testJUnit;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.entidades.tagElectronico;
import com.krakedev.peaje.servicios.EstacionPeaje;

public class TestVehiculoJUnit {
	
	@Test
	public void testRegistrarVehiculo() {
		EstacionPeaje peaje = new EstacionPeaje();
		Conductor conductor = new Conductor("1712345678", "Juan", "Perez");

		Vehiculo vehiculo = peaje.registrarVehiculo("PBX-1111", "L", conductor, "TAG-100");

		assertNotNull(vehiculo);
		assertEquals("PBX-1111", vehiculo.getPlaca());
		assertEquals("L", vehiculo.getTipo());
		assertEquals("1712345678", vehiculo.getPropietario().getCedula());
		assertEquals("TAG-100", vehiculo.getTag().getIdTag());

		Vehiculo vehiculoInvalido = peaje.registrarVehiculo("PBX-2222", "X", conductor, "TAG-101");
		assertNull(vehiculoInvalido);
	}

	@Test
	public void testRecargarTag() {
		EstacionPeaje peaje = new EstacionPeaje();
		tagElectronico tag = new tagElectronico("TAG-200");

		assertTrue(peaje.recargarTag(tag, 15.0));
		assertEquals(15.0, tag.getSaldo(), 0.0001);

		assertFalse(peaje.recargarTag(tag, -5.0));
		assertEquals(15.0, tag.getSaldo(), 0.0001);
	}

	@Test
	public void testCobrarPeaje() {
		EstacionPeaje peaje = new EstacionPeaje();
		Conductor c = new Conductor("1711111111", "Ana", "Gomez");

		Vehiculo liviano = peaje.registrarVehiculo("ABC-123", "L", c, "TAG-301");
		Vehiculo pesado = peaje.registrarVehiculo("XYZ-789", "P", c, "TAG-302");

		peaje.recargarTag(liviano.getTag(), 1.00);
		peaje.recargarTag(pesado.getTag(), 2.00);

		assertTrue(peaje.cobrarPeaje(liviano));
		assertEquals(0.0, liviano.getTag().getSaldo(), 0.0001);

		assertFalse(peaje.cobrarPeaje(pesado));
		assertEquals(2.0, pesado.getTag().getSaldo(), 0.0001);
	}

	@Test
	public void testTransferirSaldoTag() {
		EstacionPeaje peaje = new EstacionPeaje();
		tagElectronico t1 = new tagElectronico("TAG-401");
		tagElectronico t2 = new tagElectronico("TAG-402");

		peaje.recargarTag(t1, 20.0);

		assertTrue(peaje.transferirSaldoTag(t1, t2, 8.0));
		assertEquals(12.0, t1.getSaldo(), 0.0001);
		assertEquals(8.0, t2.getSaldo(), 0.0001);

		assertFalse(peaje.transferirSaldoTag(t1, t2, 15.0));
		assertEquals(12.0, t1.getSaldo(), 0.0001);
		assertEquals(8.0, t2.getSaldo(), 0.0001);
	}
}
	


