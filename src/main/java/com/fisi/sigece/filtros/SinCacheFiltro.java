/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.filtros;

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

/**
 *
 * @author josecarlos
 */
public class SinCacheFiltro implements Filter {
    
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
            
            httpResponse.setHeader("Cache-Control", "no-cache, no-store");
            httpResponse.setHeader("Pragma", "no-cache");
            httpResponse.setDateHeader("Expires", 0);
            
            chain.doFilter(request, response);
            
        } catch (ServletException | IOException ex) {
                Logger.getLogger(SinCacheFiltro.class.getName()).log(Level.SEVERE, null, ex);
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
