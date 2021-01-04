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
public class Expositor {
    private int idExpositor;
    private String nombreExpositor;
    private String especialidadExpositor;
    private String correoExpositor;
    private LocalDate fechaNacimiento;
    
    public void setIdExpositor(int idExpositor) {
        this.idExpositor = idExpositor;
    }
    
    public int getIdExpositor() {
        return idExpositor;
    }
    
    public String getEspecialidadExpositor() {
        return especialidadExpositor;
    }

    public void setEspecialidadExpositor(String especialidadExpositor) {
        this.especialidadExpositor = especialidadExpositor;
    }

    public String getCorreoExpositor() {
        return correoExpositor;
    }

    public void setCorreoExpositor(String correoExpositor) {
        this.correoExpositor = correoExpositor;
    }

    public String getNombreExpositor() {
        return nombreExpositor;
    }

    public void setNombreExpositor(String nombreExpositor) {
        this.nombreExpositor = nombreExpositor;
    }

    public String getFechaNacimiento() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; 
        return this.fechaNacimiento != null ? fechaNacimiento.format(formatter): "";
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Expositor{" + "idExpositor=" + idExpositor + ", nombreExpositor=" + nombreExpositor + ", especialidadExpositor=" + especialidadExpositor + ", correoExpositor=" + correoExpositor + '}';
    }
    
    
}
