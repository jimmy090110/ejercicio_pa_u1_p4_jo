package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements MatriculaRepository{
	
	List<Matricula>baseDatos = new ArrayList<>();

	@Override
	public void insertar(Matricula matricula) {
		this.baseDatos.add(matricula);
		
	}

	@Override
	public Matricula seleccionar(String numero) {
		 Matricula matEncontrada = new Matricula();
		 for(Matricula mat :baseDatos) {
			 if(numero.equals(mat.getNumero())) {
				 matEncontrada= mat;			 
			 }
		 }			 
		return matEncontrada;
	}

}
