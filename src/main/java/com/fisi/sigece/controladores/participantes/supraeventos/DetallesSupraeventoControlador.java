/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.participantes.supraeventos;

import com.fisi.sigece.controladores.admin.eventos.VerDetallesEventoControlador;
import com.fisi.sigece.dao.EventoDAO;
import com.fisi.sigece.dao.InscripcionDAO;
import com.fisi.sigece.dao.OtrasFuncionesDAO;
import com.fisi.sigece.dao.SupraeventoDAO;
import com.fisi.sigece.modelos.Evento;
import com.fisi.sigece.modelos.Supraevento;
import com.fisi.sigece.modelos.Usuario;
import java.io.IOException;
import java.util.List;
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
public class DetallesSupraeventoControlador extends HttpServlet {

    private final SupraeventoDAO supraeventoDAO = new SupraeventoDAO();
    private final EventoDAO eventoDAO = new EventoDAO();
    private final OtrasFuncionesDAO otrasfuncionesDAO = new OtrasFuncionesDAO();
    private final InscripcionDAO inscripcionDAO = new InscripcionDAO();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            String idSupraeventoString = request.getParameter("idSupraevento");
            if(idSupraeventoString == null || idSupraeventoString.equals("")){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }else{
                int idSupraevento = Integer.parseInt(idSupraeventoString);
                
                HttpSession miSesion= request.getSession(true);
                Usuario usuarioActual = (Usuario) miSesion.getAttribute("usuario");
                int idUsuario = usuarioActual.getIdUsuario();

                int idParticipante = otrasfuncionesDAO.obtenerIdParticipante(idUsuario);

                Supraevento supraevento = supraeventoDAO.obtenerSupraevento(idSupraevento);
                List<Evento> eventos = eventoDAO.listarEventosDeSupraevento(idSupraevento);
                boolean estaInscrito = inscripcionDAO.estaParticipanteInscritoEnSupraevento(idSupraevento, idParticipante);
                
                if(supraevento == null){
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }else{
                    request.setAttribute("supraevento", supraevento);
                    request.setAttribute("eventos", eventos);
                    request.setAttribute("estaInscrito", estaInscrito);
                    
                    request.getRequestDispatcher("/vistas/participante/supraeventos/detalles-body.jsp").forward(request, response);
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
            Logger.getLogger(DetallesSupraeventoControlador.class.getName()).log(Level.SEVERE, null, ex);
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
