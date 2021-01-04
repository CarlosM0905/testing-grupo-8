/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.asistencias;

import com.fisi.sigece.dao.AsistenciaDAO;
import com.fisi.sigece.modelos.Asistencia;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josecarlos
 */
public class AnularAsistenciaControlador extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException ex) {
            Logger.getLogger(RegistrarAsistenciaControlador.class.getName()).log(Level.SEVERE, null, ex);
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
        try{
            int idEvento = Integer.parseInt(request.getParameter("idEvento"));
            int idParticipante = Integer.parseInt(request.getParameter("idParticipante"));

            Asistencia inscripcion = new Asistencia();
            inscripcion.setIdEvento(idEvento);
            inscripcion.setIdParticipante(idParticipante);

            AsistenciaDAO asistenciaDAO = new AsistenciaDAO();
            asistenciaDAO.anularAsistencia(inscripcion);

            response.sendRedirect(request.getContextPath()+"/admin/asistencias/evento?idEvento=" + idEvento);
        } catch (NumberFormatException | IOException ex) {
            Logger.getLogger(AnularAsistenciaControlador.class.getName()).log(Level.SEVERE, null, ex);
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
