package com.krakedev.peaje.util;

public class ValidadorUtil {

	public static boolean esMontoValido(double monto) {
		return monto > 0;
	}

	public static boolean esTipoValido(String tipo) {
		if (tipo == null) {
			return false;
		}
		return tipo.equalsIgnoreCase("L") || tipo.equalsIgnoreCase("P");
	}

}
