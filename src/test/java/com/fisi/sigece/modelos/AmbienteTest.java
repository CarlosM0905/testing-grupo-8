/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.modelos;

import static org.junit.Assert.*;

/**
 *
 * @author josecarlos
 */
public class AmbienteTest {
    
    Ambiente ambiente = null;
    
    public AmbienteTest() {
        ambiente = new Ambiente();
    }
    
    /**
     * Test of getIdAmbiente method, of class Ambiente.
     */
    @org.junit.Test
    public void testGetIdAmbiente() {
        System.out.println("getIdAmbiente");
        int expResult = 4;
        ambiente.setIdAmbiente(expResult);
        int result = ambiente.getIdAmbiente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setIdAmbiente method, of class Ambiente.
     */
    @org.junit.Test
    public void testSetIdAmbiente() {
        System.out.println("setIdAmbiente");
        int expResult = 3;
        ambiente.setIdAmbiente(expResult);
        int result = ambiente.getIdAmbiente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNombreAmbiente method, of class Ambiente.
     */
    @org.junit.Test
    public void testGetNombreAmbiente() {
        System.out.println("getNombreAmbiente");
        String expResult = "ambiente 1";
        ambiente.setNombreAmbiente(expResult);
        String result = ambiente.getNombreAmbiente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of getCapacidad method, of class Ambiente.
     */
    @org.junit.Test
    public void testGetCapacidad() {
        System.out.println("getCapacidad");
        int expResult = 4;
        ambiente.setCapacidad(4);
        int result = ambiente.getCapacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Ambiente.
     */
    @org.junit.Test
    public void testToString() {
        System.out.println("toString");
        String result = ambiente.toString();
        assertNotNull(result);
    }
    
}
