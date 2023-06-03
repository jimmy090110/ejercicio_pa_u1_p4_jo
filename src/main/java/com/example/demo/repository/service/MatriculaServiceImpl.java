package com.example.demo.repository.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.VehiculoRepository;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Vehiculo;

public class MatriculaServiceImpl implements MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Autowired
	@Qualifier("automatico")
	private MatriculaCalcularServices calcularServicesAutomatico;
	
	@Autowired
	@Qualifier("manual")
	private MatriculaCalcularServices calcularServicesManual;

	@Override
	public void guardar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
		
	}

	@Override
	public Matricula buscar(String numero) {
		
		return this.matriculaRepository.seleccionar(numero);
	}

	@Override
	public void realizar(String placa, String identificacion) {
		Vehiculo vehi= new Vehiculo();
		vehi = this.vehiculoRepository.seleccionar(placa);
		Propietario prop = this.propietarioRepository.seleccionar(identificacion);
		BigDecimal valorMatricula;
		String tipo = vehi.getTipo();
		
		
		
		if(tipo.equals("A")) {
			
			valorMatricula = this.calcularServicesAutomatico.calcular(vehi.getPrecio());
		
			}else {
			valorMatricula = this.calcularServicesManual.calcular(vehi.getPrecio());
			
				
		}
		
		Matricula mat = new Matricula();
		mat.setPropietario(prop);
		mat.setValorMatricula("1233");
		mat.setVehiculo(vehi);
		mat.setNumero(placa);
		
		this.matriculaRepository.insertar(mat);
		
		
		
			
				
	}


	
	
	
	
	

}
