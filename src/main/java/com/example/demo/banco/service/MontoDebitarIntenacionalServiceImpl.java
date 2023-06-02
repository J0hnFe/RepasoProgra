package com.example.demo.banco.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("internacional")
public class MontoDebitarIntenacionalServiceImpl implements MontoDebitarService{

	@Override
	public BigDecimal calcular(BigDecimal monto) {
		BigDecimal comision = monto.multiply(new BigDecimal(0.1));
		return monto.add(comision);
	}

}
