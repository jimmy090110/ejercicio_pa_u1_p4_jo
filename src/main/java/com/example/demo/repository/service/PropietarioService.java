package com.example.demo.repository.service;

import com.example.demo.repository.modelo.Propietario;

public interface PropietarioService  {
	public void guardar(Propietario propietario);
	public Propietario buscar(String nombre);

}
