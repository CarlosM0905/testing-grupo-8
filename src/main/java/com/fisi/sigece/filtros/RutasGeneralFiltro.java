/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.filtros;

import com.fisi.sigece.modelos.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josecarlos
 */
public class RutasGeneralFiltro {
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain, Usuario.TipoUsuario tipoPermitido){
        
        try {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpServletRequest httpRequest = (HttpServletRequest) request;

            HttpSession miSesion= httpRequest.getSession(true);
            Usuario usuarioActual = (Usuario) miSesion.getAttribute("usuario");

            if(usuarioActual == null){
                httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");

            }else if(usuarioActual.getTipoUsuario().equals(tipoPermitido)){
                chain.doFilter(request, response);
            }else{
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(RutasGeneralFiltro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
