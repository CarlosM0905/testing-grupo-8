/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author josecarlos
 */
public class Supraevento {
    private int idSupraevento;
    private String nombreSupraevento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int entradasDisponibles;
    private int numeroInscritos;
    private String estadoSupraevento;

    public int getIdSupraevento() {
        return idSupraevento;
    }

    public void setIdSupraevento(int idSupraevento) {
        this.idSupraevento = idSupraevento;
    }

    public String getNombreSupraevento() {
        return nombreSupraevento;
    }

    public void setNombreSupraevento(String nombreSupraevento) {
        this.nombreSupraevento = nombreSupraevento;
    }

    public String getFechaInicio() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; 
        return this.fechaInicio !=null ? fechaInicio.format(formatter): "";
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; 
        return this.fechaFin !=null ? fechaFin.format(formatter): "";
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }

    public void setEntradasDisponibles(int entradasDisponibles) {
        this.entradasDisponibles = entradasDisponibles;
    }
    
    public boolean estaDisponible(){
        return this.estadoSupraevento.equals("DISPONIBLE");
    }
    
    public boolean estaLleno(){
        return this.estadoSupraevento.equals("LLENO");
    }

    public boolean estaFinalizado(){
        return this.estadoSupraevento.equals("FINALIZADO");
    }

    public boolean estaEnProceso(){
        return this.estadoSupraevento.equals("EN PROCESO");
    }
    
    public int getNumeroInscritos() {
        return numeroInscritos;
    }

    public void setNumeroInscritos(int numeroInscritos) {
        this.numeroInscritos = numeroInscritos;
    }

    public String getEstadoSupraevento() {
        return estadoSupraevento;
    }

    public void setEstadoSupraevento(String estadoSupraevento) {
        this.estadoSupraevento = estadoSupraevento;
    }
    
    @Override
    public String toString() {
        return "Supraevento{" + "idSupraevento=" + idSupraevento 
                + ", nombreSupraevento=" + nombreSupraevento + ", fechaInicio=" 
                + getFechaInicio() + ", fechaFin=" + getFechaFin() 
                + ", entradasDisponibles=" + entradasDisponibles 
                + ",  numeroInscritos" + numeroInscritos + ", estadoSupraevento" 
                +'}';
    }
    
}
