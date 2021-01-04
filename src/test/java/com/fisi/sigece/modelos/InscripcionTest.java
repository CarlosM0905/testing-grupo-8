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
public class InscripcionTest {
    /**
     * Test of getIdEvento method, of class Inscripcion.
     */
    @Test
    public void testGetIdEvento() {
        System.out.println("getIdEvento");
        Inscripcion instance = new Inscripcion();
        int expResult = 3;
        instance.setIdSupraevento(expResult);
        int result = instance.getIdSupraevento();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getIdParticipante method, of class Inscripcion.
     */
    @Test
    public void testGetIdParticipante() {
        System.out.println("getIdParticipante");
        Inscripcion instance = new Inscripcion();
        int expResult = 3;
        instance.setIdParticipante(expResult);
        int result = instance.getIdParticipante();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Inscripcion.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Inscripcion instance = new Inscripcion();
        String result = instance.toString();
        assertNotNull(result);
    }
    
}
