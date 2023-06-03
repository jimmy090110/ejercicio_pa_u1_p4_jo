package com.example.demo.repository.service;

import java.math.BigDecimal;

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
		BigDecimal valorM;
		String tipo = vehi.getTipo();
		
		
		
		if(tipo.equals("A")) {
			
			 valorM =this.calcularServicesAutomatico.calcular(vehi.getPrecio());
		
			}else {
			
			valorM =this.calcularServicesManual.calcular(vehi.getPrecio());
			
				
		}
		
		Matricula mat = new Matricula();
		mat.setPropietario(prop);
		mat.setValorMatricula(valorM);
		mat.setVehiculo(vehi);
		mat.setNumero(placa);
		
		this.matriculaRepository.insertar(mat);
		
		
		
			
				
	}


	
	
	
	
	

}
