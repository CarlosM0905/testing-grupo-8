/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.participantes.supraeventos;

import com.fisi.sigece.controladores.participantes.EventosProximosControlador;
import com.fisi.sigece.dao.SupraeventoDAO;
import com.fisi.sigece.modelos.Supraevento;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josecarlos
 */
public class SupraeventosProximosControlador extends HttpServlet {
    
    private final SupraeventoDAO supraeventoDAO = new SupraeventoDAO();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        procesarSolicitud(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        procesarSolicitud(request, response);
    }

    private void procesarSolicitud(HttpServletRequest request, HttpServletResponse response){
        List<Supraevento> supraeventos = supraeventoDAO.listarEntreFechas(LocalDate.now(), LocalDate.parse("2200-12-31"));
        LocalDate hoy = LocalDate.now();

        request.setAttribute("hoy", hoy);
        request.setAttribute("supraeventos_proximos", supraeventos);
            
        try {
            request.getRequestDispatcher("/vistas/participante/supraeventos/supraeventos-proximos.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
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
