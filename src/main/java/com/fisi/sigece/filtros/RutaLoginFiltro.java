/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.filtros;

import com.fisi.sigece.controladores.autentificacion.LoginControlador;
import com.fisi.sigece.modelos.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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
public class RutaLoginFiltro implements Filter {
    
    private static final String USUARIO_ATRIBUTO_SESION = "usuario";
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain){
        
        try {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpServletRequest httpRequest = (HttpServletRequest) request;

            HttpSession miSesion= httpRequest.getSession(true);
            if( miSesion.getAttribute(USUARIO_ATRIBUTO_SESION) != null ){
                redireccionar(httpRequest, httpResponse);
            }else{
                chain.doFilter(request, response);
            }
        } catch (ServletException | IOException ex) {
                Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Redirecciona dependiendo el tipo de usuario logeado
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     */
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
     * Destroy method for this filter
     */
    public void destroy() {        
        // Metodo sobreescrito para implementar Filter
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        // Metodo sobreescrito para implementar Filter
    }

}
