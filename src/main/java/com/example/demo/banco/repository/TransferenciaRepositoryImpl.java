package com.example.demo.banco.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements TransferenciaRepository {
	private static List<Transferencia> baseDatos = new ArrayList<>();

	@Override
	public void insertar(Transferencia t) {
		baseDatos.add(t);

	}

	@Override
	public void actualizar(Transferencia t) {
		this.eliminar(t.getNum());
		this.insertar(t);

	}

	@Override
	public void eliminar(String num) {
		Transferencia transf = this.seleccionarNum(num);
		baseDatos.remove(transf);

	}

	@Override
	public Transferencia seleccionarNum(String num) {
		Transferencia t = new Transferencia();
		
		for(Transferencia t_aux : baseDatos) {
			if(num.equals(t_aux.getNum())){
				t = t_aux;
			}
		}
		return t;
	}
}
