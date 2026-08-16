package com.krakedev.peaje.servicios;

import com.krakedev.peaje.entidades.Conductor;
import com.krakedev.peaje.entidades.Vehiculo;
import com.krakedev.peaje.entidades.tagElectronico;
import com.krakedev.peaje.util.ValidadorUtil;

public class EstacionPeaje {
	
	private int codigoEstacion=500;
	private double tarifaLiviano=1.00;
	private double tarifaPesado=2.50;
	public double getCodigoEstacion() {
		return codigoEstacion;
	}
	public void setCodigoEstacion(int codigoEstacion) {
		this.codigoEstacion = codigoEstacion;
	}
	public double getTarifaLiviano() {
		return tarifaLiviano;
	}
	public void setTarifaLiviano(double tarifaLiviano) {
		this.tarifaLiviano = tarifaLiviano;
	}
	public double getTarifaPesado() {
		return tarifaPesado;
	}
	public void setTarifaPesado(double tarifaPesado) {
		this.tarifaPesado = tarifaPesado;
	}
	
		public Vehiculo registrarVehiculo(String placa, String tipo, Conductor conductor, String idTag) {
			if (!ValidadorUtil.esTipoValido(tipo)) {
				return null;}
				
				Vehiculo vehiculo = new Vehiculo(placa);
				vehiculo.setTipo(tipo.toUpperCase());
				vehiculo.setPropietario(conductor);

				tagElectronico tag = new tagElectronico(idTag);
				vehiculo.setTag(tag);

				return vehiculo;
	}
		
		
		public boolean recargarTag(tagElectronico tag, double monto) {
			if (tag != null && ValidadorUtil.esMontoValido(monto) && tag.isActivo()) {
				tag.setSaldo(tag.getSaldo() + monto);
				return true;
			}
			return false;
		}

		public boolean cobrarPeaje(Vehiculo vehiculo) {
			if (vehiculo == null || vehiculo.getTag() == null || !vehiculo.getTag().isActivo()) {
				return false;
			}

			double tarifa;
			if ("L".equalsIgnoreCase(vehiculo.getTipo())) {
				tarifa = tarifaLiviano;
			} else if ("P".equalsIgnoreCase(vehiculo.getTipo())) {
				tarifa = tarifaPesado;
			} else {
				return false;
			}

			tagElectronico tag = vehiculo.getTag();
			if (tag.getSaldo() >= tarifa) {
				tag.setSaldo(tag.getSaldo() - tarifa);
				return true;
			}
			return false;
		}

		public boolean transferirSaldoTag(tagElectronico origen, tagElectronico destino, double monto) {
			if (origen == null || destino == null || !origen.isActivo() || !destino.isActivo()) {
				return false;
			}

			if (ValidadorUtil.esMontoValido(monto) && origen.getSaldo() >= monto) {
				origen.setSaldo(origen.getSaldo() - monto);
				destino.setSaldo(destino.getSaldo() + monto);
				return true;
			}
			return false;
		}
	

}
