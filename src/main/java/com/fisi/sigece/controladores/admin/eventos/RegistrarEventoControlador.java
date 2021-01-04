/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.eventos;

import com.fisi.sigece.controladores.admin.expositores.VerExpositoresControlador;
import com.fisi.sigece.dao.AmbienteDAO;
import com.fisi.sigece.dao.ExpositorDAO;
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
public class RegistrarEventoControlador extends HttpServlet {
    
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
            request.setAttribute("expositores", expositorDAO.listarExpositores());
            request.setAttribute("ambientes", ambienteDAO.listarAmbientes());
                
            request.getRequestDispatcher("/vistas/admin/eventos/registrar.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(VerExpositoresControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException ex) {
            Logger.getLogger(VerExpositoresControlador.class.getName()).log(Level.SEVERE, null, ex);
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
