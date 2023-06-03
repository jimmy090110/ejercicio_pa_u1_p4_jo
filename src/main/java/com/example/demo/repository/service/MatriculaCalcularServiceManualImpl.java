package com.example.demo.repository.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("manual")
public class MatriculaCalcularServiceManualImpl implements MatriculaCalcularServices {

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		BigDecimal comision = valor.multiply(new BigDecimal(0.10));
		return valor.add(comision);
	}

}
