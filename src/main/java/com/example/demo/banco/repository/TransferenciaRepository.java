package com.example.demo.banco.repository;

import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaRepository {
	public void insertar(Transferencia t);
	public void actualizar(Transferencia t);
	public void eliminar(String n);
	public Transferencia seleccionarNum(String n); //Selecciona transf por num. 

}
