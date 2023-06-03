package com.example.demo.repository.service;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.Matricula;

public interface MatriculaService {
	
	public void guardar(Matricula matricula);
	public Matricula buscar(String identificacion);
	
	
	void realizar(String placa, String identificacin);
}
