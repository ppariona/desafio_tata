package com.ppariona.tipocambio.dto;

import java.io.Serializable;

public class RequestCambio implements Serializable {
	private Double monto;
	private String monedaOrigen;
	private String monedaDestino;
	
	public RequestCambio() {
		super();
	}

	public RequestCambio(Double monto, String monedaOrigen, String monedaDestino) {
		super();
		this.monto = monto;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

}
