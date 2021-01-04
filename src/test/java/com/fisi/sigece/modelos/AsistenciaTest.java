/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.modelos;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josecarlos
 */
public class AsistenciaTest {
    
    /**
     * Test of getIdEvento method, of class Asistencia.
     */
    @Test
    public void testGetIdEvento() {
        System.out.println("getIdEvento");
        Asistencia instance = new Asistencia();
        int expResult = 1;
        instance.setIdEvento(expResult);
        int result = instance.getIdEvento();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreParticipante method, of class Asistencia.
     */
    @Test
    public void testGetNombreParticipante() {
        System.out.println("getNombreParticipante");
        Asistencia instance = new Asistencia();
        String expResult = "participante";
        instance.setNombreParticipante(expResult);
        String result = instance.getNombreParticipante();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdParticipante method, of class Asistencia.
     */
    @Test
    public void testGetIdParticipante() {
        System.out.println("getIdParticipante");
        Asistencia instance = new Asistencia();
        int expResult = 1;
        instance.setIdParticipante(expResult);
        int result = instance.getIdParticipante();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreSupraevento method, of class Asistencia.
     */
    @Test
    public void testGetNombreSupraevento() {
        System.out.println("getNombreSupraevento");
        Asistencia instance = new Asistencia();
        String expResult = "supraevento";
        instance.setNombreSupraevento(expResult);
        String result = instance.getNombreSupraevento();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstadoAsistencia method, of class Asistencia.
     */
    @Test
    public void testGetEstadoAsistencia() {
        System.out.println("getEstadoAsistencia");
        Asistencia instance = new Asistencia();
        String expResult = "ASISTIO";
        instance.setEstadoAsistencia(expResult);
        String result = instance.getEstadoAsistencia();
        assertEquals(expResult, result);
    }

    /**
     * Test of asistio method, of class Asistencia.
     */
    @Test
    public void testAsistio() {
        System.out.println("asistio");
        Asistencia instance = new Asistencia();
        instance.setEstadoAsistencia("ASISTIO");
        boolean expResult = true;
        boolean result = instance.asistio();
        assertEquals(expResult, result);
    }
}
