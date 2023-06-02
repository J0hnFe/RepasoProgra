package com.example.demo.banco.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cuenta {
	private String num;
	private String tipo;
	private BigDecimal saldo; // Siempre BigDecimal para monetarios
	private String cedula;


	private LocalDate fechaApertura;

	// Metodo toString
	@Override
	public String toString() {
		return "\n" + "Cuenta [num = " + num + ", tipo = " + tipo + ", saldo = " + saldo + ", fechaApertura = "
				+ fechaApertura + "]";
	}

	// Getters y Setters
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
