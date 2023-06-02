package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;

@SpringBootApplication
public class RepasoPrograApplication implements CommandLineRunner{

	@Autowired
	private TransferenciaService transferenciaService;
	@Autowired
	private CuentaService cuentaService;

	public static void main(String[] args) {
		SpringApplication.run(RepasoPrograApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		// cta1
		Cuenta cta1 = new Cuenta();
		cta1.setCedula("1718");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNum("12354");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		this.cuentaService.guardar(cta1);

		// cta 2
		Cuenta cta2 = new Cuenta();
		cta2.setCedula("1721");
		cta2.setFechaApertura(LocalDate.of(2015, 10, 10));
		cta2.setNum("321");
		cta2.setSaldo(new BigDecimal(100));
		cta2.setTipo("A");
		this.cuentaService.guardar(cta2);
		System.out.println("saldo origen " + this.cuentaService.buscarPorNumero(cta2.getNum()).getSaldo());
		System.out.println("saldo destino " + this.cuentaService.buscarPorNumero(cta1.getNum()).getSaldo());
		
		this.transferenciaService.realizar(cta1.getNum(), cta2.getNum(), new BigDecimal(10));
		this.cuentaService.actualizar(cta1);
		this.cuentaService.actualizar(cta1);

		System.out.println("saldo origen " + this.cuentaService.buscarPorNumero(cta2.getNum()).getSaldo());
		System.out.println("saldo destino " + this.cuentaService.buscarPorNumero(cta1.getNum()).getSaldo());

		/*
		this.transferenciaService.realizar(cta2.getNum(), cta1.getNum(), new BigDecimal(50));
		this.transferenciaService.realizar(cta1.getNum(), cta2.getNum(), new BigDecimal(20));
		this.transferenciaService.buscarTodos().stream().forEach(System.out::println);
		*/
		
	}



}
