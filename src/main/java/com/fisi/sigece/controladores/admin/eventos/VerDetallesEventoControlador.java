/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.eventos;

import com.fisi.sigece.dao.AmbienteDAO;
import com.fisi.sigece.dao.EventoDAO;
import com.fisi.sigece.dao.ExpositorDAO;
import com.fisi.sigece.modelos.Ambiente;
import com.fisi.sigece.modelos.Evento;
import com.fisi.sigece.modelos.Expositor;
import java.io.IOException;
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
public class VerDetallesEventoControlador extends HttpServlet {
    private final EventoDAO eventoDAO = new EventoDAO();
    private final AmbienteDAO ambienteDAO = new AmbienteDAO();
    private final ExpositorDAO expositorDAO = new ExpositorDAO();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
        
            String idEventoString = request.getParameter("idEvento");
            if(idEventoString == null || idEventoString.equals("")){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }else{
                int idEvento = Integer.parseInt(idEventoString);

                Evento evento = eventoDAO.obtenerEvento(idEvento);
                if(evento == null){
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }else{
                    Expositor expositor = expositorDAO.obtenerExpositor(evento.getIdexpositor());
                    Ambiente ambiente = ambienteDAO.obtenerAmbiente(evento.getIdambiente());
                    
                    request.setAttribute("ambiente", ambiente);
                    request.setAttribute("evento", evento);
                    request.setAttribute("expositor", expositor);

                    request.getRequestDispatcher("/vistas/admin/eventos/detalles.jsp").forward(request, response);
                }
            }

        } catch (NumberFormatException | IOException | ServletException ex) {
            Logger.getLogger(VerDetallesEventoControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VerDetallesEventoControlador.class.getName()).log(Level.SEVERE, null, ex);
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
