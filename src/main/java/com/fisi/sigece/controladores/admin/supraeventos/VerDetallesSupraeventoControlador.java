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
public class VerDetallesSupraeventoControlador extends HttpServlet {
    private final SupraeventoDAO supraeventoDAO = new SupraeventoDAO();
    private final EventoDAO eventoDAO = new EventoDAO();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
        
            String idSupraeventoString = request.getParameter("idSupraevento");
            if(idSupraeventoString == null || idSupraeventoString.equals("")){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);

            }else{
                int idSupraevento = Integer.parseInt(idSupraeventoString);

                Supraevento supraevento = supraeventoDAO.obtenerSupraevento(idSupraevento);
                List<Evento> eventos = eventoDAO.listarEventosDeSupraevento(idSupraevento);
                
                if(supraevento == null){
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }else{
                    request.setAttribute("eventos", eventos);
                    request.setAttribute("supraevento", supraevento);
                    
                    request.getRequestDispatcher("/vistas/admin/supraeventos/detalles.jsp").forward(request, response);
                }
            }

        } catch (NumberFormatException | IOException | ServletException ex) {
            Logger.getLogger(VerDetallesSupraeventoControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException ex) {
            Logger.getLogger(VerDetallesSupraeventoControlador.class.getName()).log(Level.SEVERE, null, ex);
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
