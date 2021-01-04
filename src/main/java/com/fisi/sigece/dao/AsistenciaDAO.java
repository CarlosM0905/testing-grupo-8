/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import com.fisi.sigece.modelos.Asistencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josecarlos
 */
public class AsistenciaDAO {
    
    private AccesoDB db; 
   
    public AsistenciaDAO(){
       db = new AccesoDB();
    }
    
    public List<Asistencia> listarAsistenciasDeEvento(int idEvento){
        String procedimientoalmacenado = String.format("{CALL sp_listarasitenciasdeevento(%d)}", idEvento);
        return ejecutarSelect(procedimientoalmacenado);
    }
    
    public String marcarAsistencia(Asistencia asistencia){
        String procedimientoalmacenado = "{CALL sp_marcarasistencia(?,?)}";
        return ejectuarUpdate(procedimientoalmacenado, asistencia);
    }
    
    public String anularAsistencia(Asistencia asistencia){
        String procedimientoalmacenado = "{CALL sp_anularasistencia(?,?)}";
        return ejectuarUpdate(procedimientoalmacenado, asistencia);
    }
    
    private String ejectuarUpdate(String procedimientoalmacenado, Asistencia asistencia){
        String rpta = null;
        
        Connection cn = db.getConnection();
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setInt(1, asistencia.getIdEvento());                
                cs.setInt(2, asistencia.getIdParticipante());
                
                int inserto = cs.executeUpdate();
                
                if(inserto == 0){
                    rpta = "Error";
                }
            } catch (SQLException ex) {
                Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException sqlEx){
                Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, sqlEx);
            }
        }
        return rpta;
    }
    
    private List<Asistencia> ejecutarSelect(String procedimientoalmacenado){
        List<Asistencia> lista = new LinkedList<>();
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                try (ResultSet rs = cs.executeQuery();) {
                    while(rs.next()){

                        Asistencia asistencia = new Asistencia();
                        asistencia.setIdEvento(rs.getInt("Evento_idEvento"));
                        asistencia.setIdParticipante(rs.getInt("Participante_idPersona"));
                        asistencia.setNombreEvento(rs.getString("nombre_evento"));
                        asistencia.setNombreParticipante(rs.getString("nombre_persona"));
                        asistencia.setEstadoAsistencia(rs.getString("estado_asistencia"));
                        asistencia.setNombreSupraevento(rs.getString("nombre_supraevento"));
                        
                        lista.add(asistencia);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(AsistenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    }
    
}
