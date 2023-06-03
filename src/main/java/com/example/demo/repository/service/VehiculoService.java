package com.example.demo.repository.service;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.Vehiculo;

public interface VehiculoService {
	public void guardar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo buscar(String placa);
	
	

}
