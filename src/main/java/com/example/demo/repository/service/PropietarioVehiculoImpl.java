package com.example.demo.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

@Service
public class PropietarioVehiculoImpl implements PropietarioService {
	
	@Autowired
	private PropietarioRepository propietarioRepository;

	@Override
	public void guardar(Propietario propietario) {
		this.propietarioRepository.insertar(propietario);
		
	}

	@Override
	public Propietario buscar(String nombre) {
		
		return this.propietarioRepository.seleccionar(nombre);
	}

}
