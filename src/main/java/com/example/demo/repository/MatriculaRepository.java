package com.example.demo.repository;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaRepository {
	public void insertar(Matricula matricula);
	public Matricula seleccionar(String numero);
	

}
