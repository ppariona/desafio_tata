package com.ppariona.tipocambio.service;

import java.util.List;

import com.ppariona.tipocambio.entity.Moneda;
import com.ppariona.tipocambio.entity.Cambio;

public interface TipoCambioService {

	public List<Cambio> findAll();
	public Cambio findById(Long id);
	public Cambio save(Cambio tipoCambio);
}
