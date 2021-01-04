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
 *
 * @author josecarlos
 */
public class EditarAmbienteControlador extends HttpServlet {
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
            int id = Integer.parseInt(request.getParameter("idAmbiente"));

            Ambiente ambiente = ambienteDAO.obtenerAmbiente(id);
            
            request.setAttribute("ambiente", ambiente);
            request.getRequestDispatcher("/vistas/admin/ambientes/editar.jsp").forward(request, response);
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(EditarAmbienteControlador.class.getName()).log(Level.SEVERE, null, ex);
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
            int idAmbiente = Integer.parseInt(request.getParameter("id_ambiente"));
            String nombreAmbiente = request.getParameter("nombre_ambiente");
            int idAmbienteObtenido = ambienteDAO.obtenerIdambienteDeNombre(nombreAmbiente);
            if(idAmbienteObtenido != idAmbiente && idAmbienteObtenido != -1) {
                String error = "* Ya hay otro ambiente con ese nombre registrado en el sistema";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/admin/ambientes").forward(request, response);
            } else {
                int capacidadAmbiente = Integer.parseInt(request.getParameter("capacidad_ambiente"));

                Ambiente ambienteAEditar = new Ambiente();
                ambienteAEditar.setIdAmbiente(idAmbiente);
                ambienteAEditar.setNombreAmbiente(nombreAmbiente);
                ambienteAEditar.setCapacidad(capacidadAmbiente);

                ambienteDAO.actualizarAmbiente(ambienteAEditar);

                response.sendRedirect(request.getContextPath()+"/admin/ambientes");
            }
            
        } catch (NumberFormatException | ServletException | IOException ex) {
            Logger.getLogger(EditarAmbienteControlador.class.getName()).log(Level.SEVERE, null, ex);
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
