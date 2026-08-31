package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000,"33333");
		System.out.println("----------Estado Inicial----------");
		rubia.imprimir();
		System.out.println("----------Llenando Maquina----------");
		rubia.llenarMaquina();
		rubia.imprimir();
		System.out.println("----------Servir 1000 ML----------");
		double valor;
		valor = rubia.servirCerveza(1000);
		System.out.println("Valor a pagar: "+valor);
		System.out.println("----------Servir 2000 ML----------");
		valor = rubia.servirCerveza(2000);
		System.out.println("Valor a pagar: "+valor);
		rubia.imprimir();
		System.out.println("----------Servir 6000 ML----------");
		valor = rubia.servirCerveza(6000);
		System.out.println("Valor a pagar: "+valor);
		rubia.imprimir();
	}

}
