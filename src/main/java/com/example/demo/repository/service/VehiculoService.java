package com.example.demo.repository.service;


import com.example.demo.repository.modelo.Vehiculo;

public interface VehiculoService {
	public void guardar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo buscar(String placa);
	
	

}
