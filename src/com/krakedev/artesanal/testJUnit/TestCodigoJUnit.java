package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestCodigoJUnit {

    /*
     * Valida que el codigo enviado mediante el constructor
     * que recibe capacidad maxima quede guardado correctamente.
     */
    @Test
    public void testCodigoConstructorConCapacidadMaxima() {

        Maquina maquina = new Maquina(
                "Pilsener",
                "Cerveza rubia",
                0.02,
                10000,
                "50253"
        );

        assertEquals("50253", maquina.getCodigo());
    }

    /*
     * Valida que el codigo enviado mediante el segundo constructor
     * tambien quede almacenado correctamente.
     */
    @Test
    public void testCodigoConstructorSinCapacidadMaxima() {

        Maquina maquina = new Maquina(
                "Golden Ale",
                "Cerveza artesanal",
                0.03,
                "GA001"
        );

        assertEquals("GA001", maquina.getCodigo());
    }
}