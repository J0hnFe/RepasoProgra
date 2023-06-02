package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;

@Service
public class CuentaServiceImpl implements CuentaService{

	@Autowired
	private CuentaRepository cuentaRepo;
	
	@Override
	public void guardar(Cuenta cuenta) {
		this.cuentaRepo.insertar(cuenta);
		
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		this.cuentaRepo.actualizar(cuenta);
		
	}

	@Override
	public void borrar(String numero) {
		this.cuentaRepo.eliminar(numero);
		
	}

	@Override
	public Cuenta buscarPorNumero(String numero) {
		return this.cuentaRepo.seleccionarNum(numero);
	}

}
