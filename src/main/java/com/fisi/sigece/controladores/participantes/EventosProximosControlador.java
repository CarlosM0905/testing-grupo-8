/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.participantes;

import com.fisi.sigece.dao.EventoDAO;
import com.fisi.sigece.modelos.Evento;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CUS 07 - Visualizar evento
 * @author josecarlos
 */
public class EventosProximosControlador extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        
        EventoDAO eventoDAO = new EventoDAO();
        List<Evento> eventos = eventoDAO.listarProximosEventos();
        List<Evento> eventosProximos = new ArrayList<>();
        List<Evento> eventosDeHoy = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        for(Evento ev:eventos){
            if(ev.getFechaEvento().equals(hoy.format(DateTimeFormatter.ISO_DATE))){
                eventosDeHoy.add(ev);
            }else{
                eventosProximos.add(ev);
            }
        }

        request.setAttribute("hoy", hoy);
        request.setAttribute("eventos_de_hoy", eventosDeHoy);
        request.setAttribute("eventos_proximos", eventosProximos);
            
        try {
            request.getRequestDispatcher("/vistas/participante/eventos/eventos-proximos.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EventosProximosControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException ex) {
            Logger.getLogger(EventosProximosControlador.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
