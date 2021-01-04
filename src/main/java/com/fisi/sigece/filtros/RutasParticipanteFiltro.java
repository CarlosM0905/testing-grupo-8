/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.filtros;

import com.fisi.sigece.modelos.Usuario;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filtro para las rutas participante. Primero verifica que se haya iniciado sesion
 * y luego que el usuario que se autenticó sea participante
 * @author josecarlos
 */
public class RutasParticipanteFiltro implements Filter {
    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain){
        RutasGeneralFiltro rutasFiltro = new RutasGeneralFiltro();
        rutasFiltro.doFilter(request, response, chain
                , Usuario.TipoUsuario.PARTICIPANTE);
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
        // Metodo sobreescrito para implementar Filter
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    public void init(FilterConfig filterConfig) {     
        // Metodo sobreescrito para implementar Filter
    
    }

}
