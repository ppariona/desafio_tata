package com.ppariona.tipocambio.dao;

import org.springframework.data.repository.CrudRepository;

import com.ppariona.tipocambio.entity.Cambio;
import com.ppariona.tipocambio.entity.Moneda;

public interface TipoCambioDao extends CrudRepository<Cambio, Long> {

}
