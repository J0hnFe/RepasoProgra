package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Repository
public class CuentaRepositoryImpl implements CuentaRepository{
	public static List<Cuenta> baseDatos = new ArrayList<>();
	@Override
	public void insertar(Cuenta c) {
		baseDatos.add(c);
		
	}

	@Override
	public void actualizar(Cuenta c) {
		this.eliminar(c.getNum());
		this.insertar(c);
		
	}

	@Override
	public void eliminar(String n) {
		Cuenta c = this.seleccionarNum(n);
		baseDatos.remove(c);
		
	}

	@Override
	public Cuenta seleccionarNum(String n) {
		Cuenta c = new Cuenta();
		
		for(Cuenta c_aux : baseDatos) {
			if(n.equals(c_aux.getNum())) {
				c = c_aux;
			}
		}
		
		return c;
	}



}
