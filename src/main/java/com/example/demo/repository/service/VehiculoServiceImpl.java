package com.example.demo.repository.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.VehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Override
	public void guardar(Vehiculo vehiculo) {
		this.vehiculoRepository.insertar(vehiculo);
		
	}
	
	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.vehiculoRepository.actualziar(vehiculo);
		
	}

	@Override
	public Vehiculo buscar(String placa) {
		
		return this.vehiculoRepository.seleccionar(placa);
	}





}
