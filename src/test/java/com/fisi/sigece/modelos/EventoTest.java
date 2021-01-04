/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josecarlos
 */
public class EventoTest {
    
    
    /**
     * Test of getIdambiente method, of class Evento.
     */
    @Test
    public void testGetIdambiente() {
        System.out.println("getIdambiente");
        Evento instance = new Evento();
        int expResult = 3;
        instance.setIdambiente(expResult);
        int result = instance.getIdambiente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdexpositor method, of class Evento.
     */
    @Test
    public void testGetIdexpositor() {
        System.out.println("getIdexpositor");
        Evento instance = new Evento();
        int expResult = 4;
        instance.setIdexpositor(expResult);
        int result = instance.getIdexpositor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getIdEvento method, of class Evento.
     */
    @Test
    public void testGetIdEvento() {
        System.out.println("getIdEvento");
        Evento instance = new Evento();
        int expResult = 3;
        instance.setIdEvento(expResult);
        int result = instance.getIdEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombreEvento method, of class Evento.
     */
    @Test
    public void testGetNombreEvento() {
        System.out.println("getNombreEvento");
        Evento instance = new Evento();
        String expResult = "evento 1";
        instance.setNombreEvento(expResult);
        String result = instance.getNombreEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getFechaEvento method, of class Evento.
     */
    @Test
    public void testGetFechaEvento() {
        System.out.println("getFechaEvento");
        Evento instance = new Evento();
        LocalDate expResult = LocalDate.now();
        instance.setFechaEvento(expResult);
        String result = instance.getFechaEvento();
        assertEquals(expResult.toString(), result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getHoraInicio method, of class Evento.
     */
    @Test
    public void testGetHoraInicio() {
        System.out.println("getHoraInicio");
        Evento instance = new Evento();
        String expResult = "19:10:00";
        instance.setHoraInicio(LocalTime.parse(expResult));
        String result = instance.getHoraInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getHoraFin method, of class Evento.
     */
    @Test
    public void testGetHoraFin() {
        System.out.println("getHoraFin");
        Evento instance = new Evento();
        String expResult = "19:10:00";
        instance.setHoraFin(LocalTime.parse(expResult));
        String result = instance.getHoraFin();
        System.out.println(result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getEstadoEvento method, of class Evento.
     */
    @Test
    public void testGetEstadoEvento() {
        System.out.println("getEstadoEvento");
        Evento instance = new Evento();
        String expResult = "DISPONIBLE";
        instance.setEstadoEvento(expResult);
        String result = instance.getEstadoEvento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNumeroInscritos method, of class Evento.
     */
    @Test
    public void testGetNumeroInscritos() {
        System.out.println("getNumeroInscritos");
        Evento instance = new Evento();
        int expResult = 10;
        instance.setNumeroInscritos(expResult);
        int result = instance.getNumeroInscritos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of estaDisponible method, of class Evento.
     */
    @Test
    public void testEstaDisponible() {
        System.out.println("estaDisponible");
        Evento instance = new Evento();
        instance.setEstadoEvento("DISPONIBLE");
        boolean result = instance.estaDisponible();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of estaLleno method, of class Evento.
     */
    @Test
    public void testEstaLleno() {
        System.out.println("estaLleno");
        Evento instance = new Evento();
        instance.setEstadoEvento("LLENO");
        boolean result = instance.estaLleno();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of estaFinalizado method, of class Evento.
     */
    @Test
    public void testEstaFinalizado() {
        System.out.println("estaFinalizado");
        Evento instance = new Evento();
        instance.setEstadoEvento("FINALIZADO");
        boolean result = instance.estaFinalizado();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of estaEnProceso method, of class Evento.
     */
    @Test
    public void testEstaEnProceso() {
        System.out.println("estaEnProceso");
        Evento instance = new Evento();
        instance.setEstadoEvento("EN PROCESO");
        boolean result = instance.estaEnProceso();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Evento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Evento instance = new Evento();
        String result = instance.toString();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
