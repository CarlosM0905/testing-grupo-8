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
 * CUS 03 - Editar expositor
 * @author josecarlos
 */
public class EditarExpositorControlador extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("idExpositor"));
            Expositor expositor = expositorDAO.obtenerExpositor(id);

            request.setAttribute("expositor", expositor);
            request.getRequestDispatcher("/vistas/admin/expositores/editar.jsp").forward(request, response);
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(EditarExpositorControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            int idExpositor = Integer.parseInt(request.getParameter("id_expositor"));
            String nombreExpositor = request.getParameter("nombre_expositor");
            int idExpositorObtenido = expositorDAO.obtenerIdexpositorDeNombre(nombreExpositor);
            if(idExpositorObtenido != idExpositor && idExpositorObtenido != -1){
                String error = "* Ya hay un expositor con ese nombre registrado en el sistema";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/admin/expositores").forward(request, response);
                
            } else {
                
                String especialidad = request.getParameter("especialidad_expositor");
                LocalDate fechaNacimiento = LocalDate.parse(request.getParameter("fecha_nacimiento"));
                String correoExpositor = request.getParameter("correo_expositor");

                Expositor expositor = new Expositor();
                expositor.setIdExpositor(idExpositor);
                expositor.setNombreExpositor(nombreExpositor);
                expositor.setEspecialidadExpositor(especialidad);
                expositor.setFechaNacimiento(fechaNacimiento);
                expositor.setCorreoExpositor(correoExpositor);

                expositorDAO.actualizarExpositores(expositor);

                response.sendRedirect(request.getContextPath()+"/admin/expositores");
            }
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(EditarExpositorControlador.class.getName()).log(Level.SEVERE, null, ex);
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
