/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.modelos;

/**
 *
 * @author josecarlos
 */
public class Inscripcion {
    private int idSupraevento;
    private int idParticipante;
    private String nombreParticipante;
    private String nombreSupraevento;

    public int getIdSupraevento() {
        return idSupraevento;
    }

    public void setIdSupraevento(int idEvento) {
        this.idSupraevento = idEvento;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public String getNombreEvento() {
        return nombreSupraevento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreSupraevento = nombreEvento;
    }
    
    @Override
    public String toString() {
        return "Inscripcion{" + "idSupraevento=" + idSupraevento 
                + ", idParticipante=" + idParticipante + '}';
    }
    
}
