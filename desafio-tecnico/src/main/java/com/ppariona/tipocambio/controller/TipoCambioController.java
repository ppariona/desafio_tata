package com.ppariona.tipocambio.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ppariona.tipocambio.dto.RequestCambio;
import com.ppariona.tipocambio.dto.ResponseCambio;
import com.ppariona.tipocambio.entity.Cambio;
import com.ppariona.tipocambio.entity.Moneda;
import com.ppariona.tipocambio.service.TipoCambioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class TipoCambioController {

	@Autowired
	private TipoCambioService tipoCambioService;
		
	@PostMapping("/cambio")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseCambio cambio(@RequestBody RequestCambio requestCambio) {
		Double montoCalculado = (double) 0;
		Double tipoCambio = (double) 0;
		List<Cambio> listCambioBd = tipoCambioService.findAll();
		
		
		if(requestCambio.getMonedaOrigen().equals("soles")) {
			if(requestCambio.getMonedaDestino().equals("dolares")) {
				List<Cambio> resultadoLista = listCambioBd.stream()
				    .filter(a -> Objects.equals(a.getMoneda(), "dolares"))
				    .collect(Collectors.toList());
				tipoCambio = resultadoLista.get(0).getTipoCambio();
				montoCalculado = requestCambio.getMonto() / tipoCambio;	
			}else {
				tipoCambio = (double) 0;
				montoCalculado = requestCambio.getMonto();	
			}
		} else if(requestCambio.getMonedaOrigen().equals("dolares")) {
			if(requestCambio.getMonedaDestino().equals("soles")) {
				List<Cambio> resultadoLista = listCambioBd.stream()
				    .filter(a -> Objects.equals(a.getMoneda(), "soles"))
				    .collect(Collectors.toList());
				tipoCambio = resultadoLista.get(0).getTipoCambio();
				montoCalculado = requestCambio.getMonto() * tipoCambio;	
			}else {
				tipoCambio = (double) 0;
				montoCalculado = requestCambio.getMonto();	
			}
		}
		
		ResponseCambio responseCambio = new ResponseCambio();
		responseCambio.setMonto(requestCambio.getMonto());
		responseCambio.setMontoTipoCambio(montoCalculado);
		responseCambio.setMonedaOrigen(requestCambio.getMonedaOrigen());
		responseCambio.setMonedaDestino(requestCambio.getMonedaDestino());
		responseCambio.setTipoCambio(tipoCambio);
		responseCambio.setDeveloper("Percy Pariona Alanya");
		return responseCambio;
	}
	
	 
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cambio editar(@RequestBody Cambio cambio, @PathVariable Long id) {
		Cambio cambioDb = tipoCambioService.findById(id);
		cambioDb.setTipoCambio(cambio.getTipoCambio());
		return tipoCambioService.save(cambioDb);
	}
	
	@GetMapping("/listar")
	public List<Cambio> listar(){
		return tipoCambioService.findAll();
	}
}
