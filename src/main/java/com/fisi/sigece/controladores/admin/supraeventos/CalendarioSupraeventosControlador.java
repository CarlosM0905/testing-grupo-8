/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.supraeventos;

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
public class CalendarioSupraeventosControlador extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        
        SupraeventoDAO supraeventoDAO = new SupraeventoDAO();
        List<Supraevento> supraeventos 
                = supraeventoDAO.listarEntreFechas(LocalDate.parse("1900-01-01"), LocalDate.parse("2200-01-01"));

        request.setAttribute("supraeventos", supraeventos);
        
        try {
            request.getRequestDispatcher("/vistas/admin/supraeventos/calendario.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CalendarioSupraeventosControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CalendarioSupraeventosControlador.class.getName()).log(Level.SEVERE, null, ex);
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
