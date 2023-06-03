package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements PropietarioRepository {

	List<Propietario>baseDatos = new ArrayList<>();
	@Override
	public void insertar(Propietario propietario) {
		this.baseDatos.add(propietario);
		
	}

	@Override
	public Propietario seleccionar(String nombre) {
		// TODO Auto-generated method stub
		Propietario propEncontrado = new Propietario();
		for(Propietario prop: baseDatos) {
			if(nombre.equals(prop.getNombre())) {
				propEncontrado = prop;
				
			}
		}
		return propEncontrado;
	}

}
