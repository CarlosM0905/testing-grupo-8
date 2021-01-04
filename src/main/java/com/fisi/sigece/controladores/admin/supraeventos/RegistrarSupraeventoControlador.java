/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.supraeventos;

import com.fisi.sigece.dao.EventoDAO;
import com.fisi.sigece.dao.SupraeventoDAO;
import com.fisi.sigece.modelos.Evento;
import com.fisi.sigece.modelos.Supraevento;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CUS 04 - Registar evento
 * @author josecarlos
 */
public class RegistrarSupraeventoControlador extends HttpServlet {

    private final SupraeventoDAO supraeventoDAO = new SupraeventoDAO();
    private final EventoDAO eventoDAO = new EventoDAO();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/vistas/admin/supraeventos/registrar.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RegistrarSupraeventoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        
        try {
            request.setCharacterEncoding("utf8");//Línea para que se ingresen de forma correcta los caracteres.
            Supraevento nuevoSupraevento = new Supraevento();
            
            nuevoSupraevento.setNombreSupraevento(request.getParameter("nombre_supraevento"));
            nuevoSupraevento.setEntradasDisponibles(Integer.parseInt(request.getParameter("entradas_disponibles")));
            nuevoSupraevento.setFechaInicio(LocalDate.parse(request.getParameter("fecha_inicio")));
            nuevoSupraevento.setFechaFin(LocalDate.parse(request.getParameter("fecha_fin")));
            
            List<Evento> eventos = new LinkedList<>();
            String[] nombresEvento = request.getParameterValues("nombre_evento");
            String[] fechasEvento = request.getParameterValues("fecha_evento");
            String[] ambientesId = request.getParameterValues("id_ambiente");
            String[] expositoresId = request.getParameterValues("id_expositor");
            String[] horasInicio = request.getParameterValues("hora_inicio");
            String[] horasFin = request.getParameterValues("hora_fin");
            
            for(int i = 0; i < nombresEvento.length ; i++){
                Evento evento = new Evento();
                evento.setNombreEvento(nombresEvento[i]);
                evento.setFechaEvento(LocalDate.parse(fechasEvento[i]));
                evento.setIdambiente(Integer.parseInt(ambientesId[i]));
                evento.setIdexpositor(Integer.parseInt(expositoresId[i]));
                evento.setHoraInicio(LocalTime.parse(horasInicio[i]));
                evento.setHoraFin(LocalTime.parse(horasFin[i]));
                
                eventos.add(evento);
            }
            
            int idSupraevento = supraeventoDAO.insertarSupraevento(nuevoSupraevento);
            for(Evento e:eventos){
                e.setIdSupraevento(idSupraevento);
                eventoDAO.insertarEvento(e);
            }
            
            response.sendRedirect(request.getContextPath()+"/admin/supraeventos");
        } catch (NumberFormatException | IOException ex) {
            Logger.getLogger(RegistrarSupraeventoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
