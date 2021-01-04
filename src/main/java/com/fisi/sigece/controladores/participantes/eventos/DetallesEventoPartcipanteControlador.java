/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.participantes.eventos;

import com.fisi.sigece.dao.AmbienteDAO;
import com.fisi.sigece.dao.EventoDAO;
import com.fisi.sigece.dao.ExpositorDAO;
import com.fisi.sigece.dao.InscripcionDAO;
import com.fisi.sigece.dao.OtrasFuncionesDAO;
import com.fisi.sigece.modelos.Ambiente;
import com.fisi.sigece.modelos.Evento;
import com.fisi.sigece.modelos.Expositor;
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
 *
 * @author josecarlos
 */
public class DetallesEventoPartcipanteControlador extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try{
            String idEventoString = request.getParameter("idEvento");
            int idEvento = Integer.parseInt(idEventoString);
        
            HttpSession miSesion= request.getSession(true);
            Usuario usuarioActual = (Usuario) miSesion.getAttribute("usuario");
            int idUsuario = usuarioActual.getIdUsuario();

            OtrasFuncionesDAO otrasfuncionesDAO = new OtrasFuncionesDAO();
            EventoDAO eventoDAO = new EventoDAO();
            AmbienteDAO ambienteDAO = new AmbienteDAO();
            ExpositorDAO expositorDAO = new ExpositorDAO();
            InscripcionDAO inscripcionDAO = new InscripcionDAO();

            int idParticipante = otrasfuncionesDAO.obtenerIdParticipante(idUsuario);

            Evento evento = eventoDAO.obtenerEvento(idEvento);
            Ambiente ambiente = ambienteDAO.obtenerAmbiente(evento.getIdambiente());
            Expositor expositor = expositorDAO.obtenerExpositor(evento.getIdexpositor());
            boolean estaInscrito = inscripcionDAO.estaParticipanteInscritoEnSupraevento(idEvento, idParticipante);

            request.setAttribute("evento_escogido", evento);
            request.setAttribute("ambiente", ambiente);
            request.setAttribute("expositor", expositor);
            request.setAttribute("estaInscrito", estaInscrito);

            //SUCCESS
            request.getRequestDispatcher("/vistas/participante/eventos/detalles-body.jsp").forward(request, response);
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(DetallesEventoPartcipanteControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException ex) {
            Logger.getLogger(DetallesEventoPartcipanteControlador.class.getName()).log(Level.SEVERE, null, ex);
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
