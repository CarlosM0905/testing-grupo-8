/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.asistencias;

import com.fisi.sigece.dao.AsistenciaDAO;
import com.fisi.sigece.dao.EventoDAO;
import com.fisi.sigece.modelos.Asistencia;
import com.fisi.sigece.modelos.Evento;
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
public class ReporteAsistencias extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String idEventoString = request.getParameter("idEvento");
            if(idEventoString == null || idEventoString.equals("")){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }else{
                EventoDAO eventoDAO = new EventoDAO();
                AsistenciaDAO asistenciaDAO = new AsistenciaDAO();
                
                int idEvento = Integer.parseInt(idEventoString);
                
                Evento evento = eventoDAO.obtenerEvento(idEvento);
                if(evento == null){
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }else{
                    List<Asistencia> asistencias = asistenciaDAO.listarAsistenciasDeEvento(idEvento);

                    request.setAttribute("asistencias", asistencias);
                    request.setAttribute("evento", evento);
                    request.getRequestDispatcher("/vistas/admin/asistencias/reporte.jsp").forward(request, response);
                }
            }
        } catch (NumberFormatException | IOException | ServletException ex) {
            Logger.getLogger(ReporteAsistencias.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReporteAsistencias.class.getName()).log(Level.SEVERE, null, ex);
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
