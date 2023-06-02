package com.example.demo.banco.repository;

import com.example.demo.banco.repository.modelo.Cuenta;

public interface CuentaRepository {

	public void insertar(Cuenta c);
	public void actualizar(Cuenta c);
	public void eliminar(String n);
	public Cuenta seleccionarNum(String n); //Selecciona cta por num. 
}
