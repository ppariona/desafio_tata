package com.ppariona.tipocambio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ppariona.tipocambio.dao.TipoCambioDao;
import com.ppariona.tipocambio.entity.Moneda;
import com.ppariona.tipocambio.entity.Cambio;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
	
	@Autowired
	private TipoCambioDao tipoCambioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cambio> findAll() {
		return (List<Cambio>) tipoCambioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cambio findById(Long id) {
		return tipoCambioDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Cambio save(Cambio tipoCambio) {
		return tipoCambioDao.save(tipoCambio);
	}

}
