package com.krakedev.peaje.util;

public class ValidadorUtil {
	
		public boolean esMontoValido(double monto) {
			return monto>0;
			}
		
		public boolean esTipoValido(String tipo) {
			if(tipo=="L" ||tipo == "P") {
				return true;
			}else {
				return false;
			}
		}
		
}
