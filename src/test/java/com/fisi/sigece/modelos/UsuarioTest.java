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
public class UsuarioTest {
    
    /**
     * Test of getIdUsuario method, of class Usuario.
     */
    @Test
    public void testGetIdUsuario() {
        System.out.println("getIdUsuario");
        Usuario instance = new Usuario();
        int expResult = 4;
        instance.setIdUsuario(expResult);
        int result = instance.getIdUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombreUsuario method, of class Usuario.
     */
    @Test
    public void testGetNombreUsuario() {
        System.out.println("getNombreUsuario");
        Usuario instance = new Usuario();
        String expResult = "usuario 1";
        instance.setNombreUsuario(expResult);
        String result = instance.getNombreUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipoUsuario method, of class Usuario.
     */
    @Test
    public void testGetTipoUsuario() {
        System.out.println("getTipoUsuario");
        Usuario instance = new Usuario();
        Usuario.TipoUsuario expResult = Usuario.TipoUsuario.ADMIN;
        instance.setTipoUsuario(expResult);
        Usuario.TipoUsuario result = instance.getTipoUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Usuario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Usuario instance = new Usuario();
        String result = instance.toString();
        assertNotNull(result);
    }
    
}
