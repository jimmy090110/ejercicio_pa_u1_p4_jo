package com.example.demo.repository.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("automatico")
public class MatriculaCalcularServiceAutomaticosImpl implements MatriculaCalcularServices {

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		BigDecimal comision = valor.multiply(new BigDecimal(0.15));
		return valor.add(comision);
	}

}
