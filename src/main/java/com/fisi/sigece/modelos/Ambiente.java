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
public class Ambiente {
    private int idAmbiente;
    private String nombreAmbiente;
    private int capacidad;

    public int getIdAmbiente() {
        return idAmbiente;
    }

    public void setIdAmbiente(int idAmbiente) {
        this.idAmbiente = idAmbiente;
    }

    public String getNombreAmbiente() {
        return nombreAmbiente;
    }

    public void setNombreAmbiente(String nombreAmbiente) {
        this.nombreAmbiente = nombreAmbiente;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int aforo) {
        this.capacidad = aforo;
    }

    @Override
    public String toString() {
        return "Ambiente{" + "idAmbiente=" + idAmbiente + ", nombreAmbiente=" + nombreAmbiente + ", aforo=" + capacidad + '}';
    }
    
    
}
