package com.example.demo.banco.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transferencia {
	private String num;
	private BigDecimal monto;
	private LocalDateTime fecha;
	private Cuenta ctaOrigen;
	private Cuenta ctaDestino;

	// toString
	@Override
	public String toString() {
		return "\nTransferencia [num = " + num + ", monto = " + monto + ", fecha = " 
				+ fecha + ", \nctaOrigen = " + ctaOrigen + ", \nctaDestino = " + ctaDestino + "]";
	}

	// Getters y Setters
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCtaOrigen() {
		return ctaOrigen;
	}

	public void setCtaOrigen(Cuenta ctaOrigen) {
		this.ctaOrigen = ctaOrigen;
	}

	public Cuenta getCtaDestino() {
		return ctaDestino;
	}

	public void setCtaDestino(Cuenta ctaDestino) {
		this.ctaDestino = ctaDestino;
	}

}
