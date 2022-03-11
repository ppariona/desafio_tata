package com.ppariona.tipocambio.dto;

import java.io.Serializable;

public class ResponseCambio implements Serializable{
	private Double monto;
	private Double montoTipoCambio;
	private String monedaOrigen;
	private String monedaDestino;
	private String developer;
	private Double tipoCambio;
	
	public ResponseCambio() {
		super();
	}

	public ResponseCambio(Double monto, Double montoTipoCambio, String monedaOrigen, 
			String monedaDestino, String developer, Double tipoCambio) {
		super();
		this.monto = monto;
		this.montoTipoCambio = montoTipoCambio;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.developer = developer;
		this.tipoCambio = tipoCambio;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Double getMontoTipoCambio() {
		return montoTipoCambio;
	}

	public void setMontoTipoCambio(Double montoTipoCambio) {
		this.montoTipoCambio = montoTipoCambio;
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

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	
	

}
