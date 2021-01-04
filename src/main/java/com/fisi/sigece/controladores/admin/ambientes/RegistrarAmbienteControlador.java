/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.controladores.admin.ambientes;

import com.fisi.sigece.dao.AmbienteDAO;
import com.fisi.sigece.modelos.Ambiente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CUS 05 - Registrar ambiente
 * @author josecarlos
 */
public class RegistrarAmbienteControlador extends HttpServlet {

    private final AmbienteDAO ambienteDAO = new AmbienteDAO();
            
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/vistas/admin/ambientes/registrar.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RegistrarAmbienteControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            String nombreAmbiente = request.getParameter("nombre_ambiente");
            if(ambienteDAO.obtenerIdambienteDeNombre(nombreAmbiente) != -1){
                String error = "* Ya existe un ambiente con ese nombre";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/vistas/admin/ambientes/registrar.jsp").forward(request, response);
            }
            
            int capacidadAmbiente = Integer.parseInt(request.getParameter("capacidad_ambiente"));
            Ambiente ambienteARegistrar = new Ambiente();
            ambienteARegistrar.setNombreAmbiente(nombreAmbiente);
            ambienteARegistrar.setCapacidad(capacidadAmbiente);

            ambienteDAO.insertarAmbiente(ambienteARegistrar);

            response.sendRedirect(request.getContextPath()+"/admin/ambientes");
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(RegistrarAmbienteControlador.class.getName()).log(Level.SEVERE, null, ex);
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
