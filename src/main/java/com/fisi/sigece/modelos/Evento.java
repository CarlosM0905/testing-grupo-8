package com.fisi.sigece.modelos;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private int idEvento;
    private String nombreEvento;
    private LocalDate fechaEvento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int idambiente;
    private int idexpositor;
    private int numeroInscritos;
    private String estadoEvento;
    private int idSupraevento;
    
    public int getIdambiente() {
        return idambiente;
    }

    public void setIdambiente(int idambiente) {
        this.idambiente = idambiente;
    }

    public int getIdexpositor() {
        return idexpositor;
    }

    public void setIdexpositor(int idexpositor) {
        this.idexpositor = idexpositor;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
    
    public int getIdEvento(){
        return this.idEvento;
    }
    
    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFechaEvento() {
        
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; 
        return this.fechaEvento !=null ? fechaEvento.format(formatter): "";
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getHoraInicio() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME; 
        return horaInicio!=null ? horaInicio.format(formatter): "";
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME; 
        return horaFin!=null ? horaFin.format(formatter) : "";
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public int getNumeroInscritos() {
        return numeroInscritos;
    }

    public void setNumeroInscritos(int inscritos) {
        this.numeroInscritos = inscritos;
    }

    public int getIdSupraevento() {
        return idSupraevento;
    }

    public void setIdSupraevento(int idSupraevento) {
        this.idSupraevento = idSupraevento;
    }
    
    public boolean estaDisponible(){
        return "DISPONIBLE".equalsIgnoreCase(this.estadoEvento);
    }
    
    public boolean estaLleno(){
        return "LLENO".equalsIgnoreCase(this.estadoEvento);
    }
    
    public boolean estaFinalizado(){
        return "FINALIZADO".equalsIgnoreCase(this.estadoEvento);
    }
    
    public boolean estaEnProceso(){
        return "EN PROCESO".equalsIgnoreCase(this.estadoEvento);
    }
    
    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", nombreEvento=" 
                + nombreEvento + ", fechaEvento=" + getFechaEvento() 
                + ", idambiente=" + idambiente + ", horaInicio="+ getHoraInicio() 
                + ", horaFin="+ getHoraFin() + ", idexpositor="+ idexpositor 
                + ", estadoEvento="+ estadoEvento + "numeroInscritos" 
                + numeroInscritos + ", idSupraevento=" + idSupraevento + '}';
    }
   
}