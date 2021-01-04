/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.participantes.inscripcion;

import com.fisi.sigece.dao.InscripcionDAO;
import com.fisi.sigece.dao.OtrasFuncionesDAO;
import com.fisi.sigece.modelos.Inscripcion;
import com.fisi.sigece.modelos.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * CUS 09 - Anular asistencia
 * @author josecarlos
 */
public class AnularInscripcionControlador extends HttpServlet {

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
            Logger.getLogger(AnularInscripcionControlador.class.getName()).log(Level.SEVERE, null, ex);
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
        
            int idEvento = Integer.parseInt(request.getParameter("idSupraevento"));
            HttpSession miSesion = request.getSession(true);
            Usuario usuarioActual = (Usuario) miSesion.getAttribute("usuario");
            int idUsuario = usuarioActual.getIdUsuario();

            OtrasFuncionesDAO otrasfuncionesDAO = new OtrasFuncionesDAO();
            int idParticipante = otrasfuncionesDAO.obtenerIdParticipante(idUsuario);

            Inscripcion inscripcionAEliminar = new Inscripcion();
            inscripcionAEliminar.setIdSupraevento(idEvento);
            inscripcionAEliminar.setIdParticipante(idParticipante);

            InscripcionDAO inscripcionDAO = new InscripcionDAO();
            inscripcionDAO.anularInscripcionEnSupraevento(inscripcionAEliminar);
            
            String exito = "* Usted ha anulado su inscripcion en el evento";
            request.setAttribute("exito", exito);
            request.getRequestDispatcher("/participante/supraeventos").forward(request, response);
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(AnularInscripcionControlador.class.getName()).log(Level.SEVERE, null, ex);
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
