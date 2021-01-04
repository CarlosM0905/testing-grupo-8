/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.participantes.supraeventos;

import com.fisi.sigece.dao.OtrasFuncionesDAO;
import com.fisi.sigece.dao.SupraeventoDAO;
import com.fisi.sigece.modelos.Supraevento;
import com.fisi.sigece.modelos.Usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * CUS 06 - Visualizar asistencia
 * @author josecarlos
 */
public class MisSupraeventosControlador extends HttpServlet {

    private final OtrasFuncionesDAO otrasfuncionesDAO = new OtrasFuncionesDAO();
    private final SupraeventoDAO supraeventoDAO = new SupraeventoDAO();
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
       try{
            HttpSession miSesion= request.getSession(true);
            Usuario usuarioActual = (Usuario) miSesion.getAttribute("usuario");
            int idUsuario = usuarioActual.getIdUsuario();
            int idParticipante = otrasfuncionesDAO.obtenerIdParticipante(idUsuario);

            List<Supraevento> supraeventos 
                    = supraeventoDAO.listarSupraeventosDeParticipante(idParticipante
                            , LocalDate.now(), LocalDate.parse("2200-12-31"));

            request.setAttribute("supraeventos", supraeventos);
            request.getRequestDispatcher("/vistas/participante/supraeventos/mis-supraeventos.jsp")
                    .forward(request, response);
            
        } catch (ServletException | IOException ex) {
            Logger.getLogger(MisSupraeventosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        try{
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException ex) {
            Logger.getLogger(MisSupraeventosControlador.class.getName()).log(Level.SEVERE, null, ex);
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
