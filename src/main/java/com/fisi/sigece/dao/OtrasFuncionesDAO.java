/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josecarlos
 */
public class OtrasFuncionesDAO {
    private AccesoDB db; 
    
    public OtrasFuncionesDAO(){
        db = new AccesoDB();
    }
    
    public int obtenerIdParticipante(int idUsuario){
        int idParticipanteObtenido = -1;
        String funcionalmacenada = "{? = CALL fu_obteneridparticipante(?)}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(funcionalmacenada)){
            
                cs.registerOutParameter(1, java.sql.Types.INTEGER);
                
                cs.setInt(2, idUsuario);
                cs.execute();
                idParticipanteObtenido = cs.getInt(1);
                
            } catch (SQLException ex) {
                Logger.getLogger(OtrasFuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(OtrasFuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return idParticipanteObtenido;
    }
}
