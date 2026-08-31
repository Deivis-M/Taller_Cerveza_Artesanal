package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
	private static final double TOLERANCIA = 0.0001;

	/*
	 * * Valida que, cuando hay suficiente cerveza disponible, * la máquina sirva la
	 * cantidad solicitada, descuente esa * cantidad del contenido actual y retorne
	 * el valor correcto a pagar. * * Se utiliza el constructor que recibe capacidad
	 * máxima.
	 */ @Test
	public void testServirCervezaConCantidadSuficienteConstructorCompleto() {
		Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.02, 5000,"001");
		maquina.recargarCerveza(1000);
		double valorPagado = maquina.servirCerveza(300);
		assertEquals(6.0, valorPagado, TOLERANCIA);
		assertEquals(700.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/*
	 * * Valida el funcionamiento correcto utilizando el segundo constructor, * que
	 * establece automáticamente la capacidad máxima de la máquina.
	 */ @Test
	public void testServirCervezaConSegundoConstructor() {
		Maquina maquina = new Maquina("IPA", "Cerveza artesanal", 0.015,"002");
		maquina.recargarCerveza(2000);
		double valorPagado = maquina.servirCerveza(500);
		assertEquals(7.5, valorPagado, TOLERANCIA);
		assertEquals(1500.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/*
	 * * Valida que sea posible servir exactamente toda la cerveza * disponible en
	 * la máquina. * * Después de servir, la cantidad actual debe quedar en cero.
	 */ @Test
	public void testServirExactamenteCantidadDisponible() {
		Maquina maquina = new Maquina("Stout", "Cerveza oscura", 0.025, 3000,"003");
		maquina.recargarCerveza(800);
		double valorPagado = maquina.servirCerveza(800);
		assertEquals(20.0, valorPagado, TOLERANCIA);
		assertEquals(0.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/*
	 * * Valida que, si se solicita más cerveza de la disponible, * la máquina no
	 * sirva nada. * * Debe retornar 0 y conservar exactamente la misma cantidad
	 * actual.
	 */ @Test
	public void testNoServirCuandoCantidadSolicitadaEsMayorALaDisponible() {
		Maquina maquina = new Maquina("Porter", "Cerveza fuerte", 0.018, 4000,"004");
		maquina.recargarCerveza(500);
		double cantidadAntes = maquina.getCantidadActual();
		double valorPagado = maquina.servirCerveza(700);
		assertEquals(0.0, valorPagado, TOLERANCIA);
		assertEquals(cantidadAntes, maquina.getCantidadActual(), TOLERANCIA);
	}

	/*
	 * * Valida que una máquina sin cerveza no pueda atender * una solicitud. * *
	 * Debe retornar 0 y la cantidad actual debe continuar en cero.
	 */ @Test
	public void testNoServirCuandoMaquinaEstaVacia() {
		Maquina maquina = new Maquina("Lager", "Cerveza ligera", 0.01,"005");
		double valorPagado = maquina.servirCerveza(250);
		assertEquals(0.0, valorPagado, TOLERANCIA);
		assertEquals(0.0, maquina.getCantidadActual(), TOLERANCIA);
	}

	/*
	 * * Valida el cálculo del precio utilizando una cantidad y * un precio por
	 * mililitro con valores decimales. * * También verifica que el descuento de
	 * cerveza sea correcto.
	 */ @Test
	public void testCalculoConValoresDecimales() {
		Maquina maquina = new Maquina("Amber", "Cerveza ámbar", 0.0175, 2500,"006");
		maquina.recargarCerveza(1000.5);
		double valorPagado = maquina.servirCerveza(250.5);
		assertEquals(4.38375, valorPagado, TOLERANCIA);
		assertEquals(750.0, maquina.getCantidadActual(), TOLERANCIA);
	}
}