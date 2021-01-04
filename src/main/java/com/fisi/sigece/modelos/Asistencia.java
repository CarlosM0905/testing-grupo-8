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
public class Asistencia {
    private int idEvento;
    private int idParticipante;
    private String nombreParticipante;
    private String nombreSupraevento;
    private String estadoAsistencia;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreSupraevento = nombreEvento;
    }
    
    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombreSupraevento() {
        return nombreSupraevento;
    }

    public void setNombreSupraevento(String nombreSupraevento) {
        this.nombreSupraevento = nombreSupraevento;
    }
    
    public String getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(String estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    public boolean asistio(){
        return this.estadoAsistencia.equals("ASISTIO");
    }
    
    @Override
    public String toString() {
        return "Asistencia{" + "idEvento=" + idEvento 
                + ", idParticipante=" + idParticipante + '}';
    }
    
}
