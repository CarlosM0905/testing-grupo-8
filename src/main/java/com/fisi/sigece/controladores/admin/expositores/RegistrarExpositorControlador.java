/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.expositores;

import com.fisi.sigece.dao.ExpositorDAO;
import com.fisi.sigece.modelos.Expositor;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CUS 02 - Registrar expositor
 * @author josecarlos
 */
public class RegistrarExpositorControlador extends HttpServlet {

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
            request.getRequestDispatcher("/vistas/admin/expositores/registrar.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RegistrarExpositorControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            
            request.setCharacterEncoding("utf8");//Línea para que se ingresen de forma correcta los caracteres.
            String nombreExpositor = request.getParameter("nombre_expositor");
            
            if(expositorDAO.obtenerIdexpositorDeNombre(nombreExpositor) != -1){
                String error = "* Ya hay un expositor con ese nombre registrado en el sistema";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/vistas/admin/expositores/registrar.jsp").forward(request, response);
                
            } else {
                
                String especialidad = request.getParameter("especialidad_expositor");
                LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fecha_nacimiento"));
                String correoExpositor = request.getParameter("correo_expositor");
                Expositor expositor = new Expositor();
                expositor.setNombreExpositor(nombreExpositor);
                expositor.setEspecialidadExpositor(especialidad);
                expositor.setFechaNacimiento(fechaNacimiento);
                expositor.setCorreoExpositor(correoExpositor);

                expositorDAO.insertarExpositor(expositor);

                response.sendRedirect(request.getContextPath()+"/admin/expositores");
            }
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(RegistrarExpositorControlador.class.getName()).log(Level.SEVERE, null, ex);
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
