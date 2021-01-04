/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.autentificacion;

import com.fisi.sigece.dao.UsuarioDAO;
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
 * CUS 01 - Ingreso al sistema
 * @author josecarlos
 */
public class LoginControlador extends HttpServlet {

    private static final String USUARIO_ATRIBUTO_SESION = "usuario";
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/vistas/login/login.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
                Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
            String nombreUsuario = request.getParameter("username");
            String contrasenia = request.getParameter("password");
        
            HttpSession miSesion= request.getSession(true);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.obtenerUsuario(nombreUsuario, contrasenia);

            //Si se verifica que es un usuario registrado
            if (usuario!=null) {
                miSesion.setAttribute(USUARIO_ATRIBUTO_SESION, usuario);
                miSesion.setMaxInactiveInterval(30*60);
                redireccionar(request, response);
            } else {
                String error = "* Nombre de usuario y/o contraseña inválidos";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/vistas/login/login.jsp").forward(request, response);
            }
        } catch (IOException | ServletException ex) {
                Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void redireccionar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        HttpSession miSesion= request.getSession(true);
        Usuario usuarioIdentificado = (Usuario) miSesion.getAttribute(USUARIO_ATRIBUTO_SESION);
        
        //Si se trata de un usuario de tipo admin
        if(usuarioIdentificado.getTipoUsuario() == Usuario.TipoUsuario.ADMIN){
            response.sendRedirect(request.getContextPath()+"/admin");

        //Si se trata de un usuario de tipo participante
        }else if(usuarioIdentificado.getTipoUsuario() 
                            == Usuario.TipoUsuario.PARTICIPANTE){

            response.sendRedirect(request.getContextPath()+"/participante");
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
