/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.modelos;

import java.io.Serializable;

/**
 *
 * @author josecarlos
 */
public class Usuario implements Serializable{
    public enum TipoUsuario{
        ADMIN,
        PARTICIPANTE
    }
    
    private int idUsuario;
    private String nombreUsuario;
    private TipoUsuario tipoUsuario;
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" 
                + nombreUsuario + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
    
}
