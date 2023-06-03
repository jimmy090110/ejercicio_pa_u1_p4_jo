package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements VehiculoRepository{
	List<Vehiculo>baseDatos= new ArrayList<>();

	@Override
	public void insertar(Vehiculo vehiculo) {
		this.baseDatos.add(vehiculo);
		
	}

	
	@Override
	public void actualziar(Vehiculo vehiculo) {
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		Vehiculo vehi = this.seleccionar(placa);
		this.baseDatos.remove(vehi);
		
	}

	@Override
	public Vehiculo seleccionar(String placa) {
		Vehiculo vehiEncontrado = new Vehiculo();
		for(Vehiculo vehi: baseDatos) {
			if(placa.equals(vehi.getPlaca())) {
				vehiEncontrado = vehi;
				
			}
		}
		return vehiEncontrado;
	}


}
