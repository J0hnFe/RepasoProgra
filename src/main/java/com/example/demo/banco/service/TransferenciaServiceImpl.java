package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepositoryImpl;
import com.example.demo.banco.repository.TransferenciaRepositoryImpl;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{
	@Autowired
	private TransferenciaRepositoryImpl transferenciaRepo;
	@Autowired
	private CuentaRepositoryImpl cuentaRepo;
	@Autowired
	@Qualifier("nacional")
	private MontoDebitarService montoDebSer;
	
	@Override
	public void guardar(Transferencia transferencia) {
		this.transferenciaRepo.insertar(transferencia);
		
	}
	@Override
	public void actualizar(Transferencia transferencia) {
		this.transferenciaRepo.actualizar(transferencia);
		
	}
	@Override
	public void borrar(String numero) {
		this.transferenciaRepo.eliminar(numero);
		
	}
	@Override
	public Transferencia buscarPorNumero(String numero) {
		return this.transferenciaRepo.seleccionarNum(numero);
	}
	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// 1. Consultar la cuenta de origen por el num.
		Cuenta ctaOrigen = this.cuentaRepo.seleccionarNum(numeroCtaOrigen);

		// 2. Consultar el saldo de la cuenta origen.
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal montoDebitar = this.montoDebSer.calcular(monto);

		// 3. Validar si el saldo es suuuuficiente
		if (montoDebitar.compareTo(saldoOrigen) <= 0) {

			// 5. Si, si es suficiente, ir al paso 6.
			// 6. Realizamos la resta de la cuenta origen (saldo origen - monto)
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(montoDebitar);
			
			// 7. Actualizamos el saldo de la cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepo.actualizar(ctaOrigen);

			// 8. Consultamos la cuenta de destino por el num.
			Cuenta ctaDestino = this.cuentaRepo.seleccionarNum(numeroCtaDestino);
			
			// 9. Consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			
			// 10. Realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);

			// 11. Actualizamos el nuevo saldo de la cta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaRepo.actualizar(ctaDestino);
			
			// 12. Creamos la transferencia
			Transferencia trans = new Transferencia();
			
			trans.setCtaDestino(ctaDestino);
			trans.setCtaOrigen(ctaOrigen);
			trans.setFecha(LocalDateTime.now());
			trans.setMonto(monto);
			
			Double num = Math.random();
			
			trans.setNum(num.toString());
			
			this.transferenciaRepo.insertar(trans);

		} else {
			// 4. Si no es suficiente imprimir mensaje de "no saldo"
			System.out.println("Saldo no diponible, su saldo es: " + saldoOrigen);
		}
		
	}
	@Override
	public List<Transferencia> buscarTodos() {
		return this.transferenciaRepo.buscarTodos();
	}
	
	

}
