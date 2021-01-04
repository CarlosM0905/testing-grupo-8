/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.modelos;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josecarlos
 */
public class ExpositorTest {
    
    /**
     * Test of getIdExpositor method, of class Expositor.
     */
    @Test
    public void testGetIdExpositor() {
        System.out.println("getIdExpositor");
        Expositor instance = new Expositor();
        int expResult = 4;
        instance.setIdExpositor(expResult);
        int result = instance.getIdExpositor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getEspecialidadExpositor method, of class Expositor.
     */
    @Test
    public void testGetEspecialidadExpositor() {
        System.out.println("getEspecialidadExpositor");
        Expositor instance = new Expositor();
        String expResult = "MEDICINA";
        instance.setEspecialidadExpositor(expResult);
        String result = instance.getEspecialidadExpositor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEdadExpositor method, of class Expositor.
     */
    @Test
    public void testGetFechaNacimientoExpositor() {
        System.out.println("getEdadExpositor");
        Expositor instance = new Expositor();
        LocalDate fechaNacimiento = LocalDate.parse("1980-01-01");
        instance.setFechaNacimiento(fechaNacimiento);
        String result = instance.getFechaNacimiento();
        assertEquals(fechaNacimiento.toString(), result);
    }

    /**
     * Test of getCorreoExpositor method, of class Expositor.
     */
    @Test
    public void testGetCorreoExpositor() {
        System.out.println("getCorreoExpositor");
        Expositor instance = new Expositor();
        String expResult = "12345@gmail.com";
        instance.setCorreoExpositor(expResult);
        String result = instance.getCorreoExpositor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreExpositor method, of class Expositor.
     */
    @Test
    public void testGetNombreExpositor() {
        System.out.println("getNombreExpositor");
        Expositor instance = new Expositor();
        String expResult = "expo 1";
        instance.setNombreExpositor(expResult);
        String result = instance.getNombreExpositor();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Expositor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Expositor instance = new Expositor();
        String result = instance.toString();
        assertNotNull(result);
    }
    
}
