package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.service.MatriculaService;
import com.example.demo.repository.service.PropietarioService;
import com.example.demo.repository.service.VehiculoService;

@SpringBootApplication
public class EjercicioPaU1Application  implements CommandLineRunner{
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@Autowired
	private PropietarioService propietarioService;
	
	@Autowired
	private MatriculaService matriculaService;
	


	public static void main(String[] args) {
		SpringApplication.run(EjercicioPaU1Application.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		
		//1. Crear Vehiculo
		Vehiculo vehi = new Vehiculo();
		vehi.setMarca("Ford");
		vehi.setModelo("2025");
		vehi.setPlaca("ABC123");
		vehi.setPrecio(new BigDecimal(2000));
		vehi.setTipo("A");
		
		this.vehiculoService.guardar(vehi);
		System.out.println(vehi);
		
		//2. Actualizar Vehiculo
		
		vehi.setMarca("Chevrolett");
		vehi.setTipo("M");
		
		this.vehiculoService.actualizar(vehi);
		System.out.println(vehi);
		
		//3.Crear propietario
		Propietario prop = new Propietario();
		prop.setIdentificacion("0105966337");
		prop.setFechaNacimiento(LocalDateTime.now());
		prop.setNombre("Jimmy");
		prop.setApellido("Ortega");
		
		this.propietarioService.guardar(prop);
		System.out.println(prop);
		
		
		//this.matriculaService.realizar(vehi.getPlaca(), prop.getIdentificacion());
		
		
		
		
	}

}
