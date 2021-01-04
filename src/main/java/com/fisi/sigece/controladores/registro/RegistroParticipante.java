/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.registro;

import com.fisi.sigece.controladores.autentificacion.LoginControlador;
import com.fisi.sigece.dao.UsuarioDAO;
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
public class RegistroParticipante extends HttpServlet {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("/vistas/registro/registro-participante.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            String nombreUsuario = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contrasenia");
            String nombrePersona = request.getParameter("nombrePersona");
            
            if(usuarioDAO.existeNombreUsuario(nombreUsuario)){
                String error = "* Nombre de usuario ya está registrado";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/vistas/registro/registro-participante.jsp").forward(request, response);
            }else{
                usuarioDAO.registrarParticipante(nombreUsuario, contrasenia, nombrePersona);
                response.sendRedirect(request.getContextPath() + "/login");
            }
            
        } catch (IOException | ServletException ex) {
                Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
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
