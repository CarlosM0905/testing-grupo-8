/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import com.fisi.sigece.modelos.Supraevento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josecarlos
 */
public class SupraeventoDAO {
    private AccesoDB db; 
   
    public SupraeventoDAO(){
       db = new AccesoDB();
    }
    
    public Supraevento obtenerSupraevento(int idSupraevento){
        String procedimientoalmacenado 
                = String.format("{CALL sp_obtenersupraevento(%d)}", idSupraevento);
        
        List<Supraevento> resultado = ejecutarSelect(procedimientoalmacenado);
        return resultado.isEmpty() ? null : resultado.get(0);
    }
    
    
    public List<Supraevento> listarEntreFechas(LocalDate desdeFecha, LocalDate hastaFecha){
        String procedimientoalmacenado 
                = String.format("{CALL sp_listarsupraeventoentrefechas('%s' ,'%s')}"
                                , desdeFecha.toString(), hastaFecha.toString());        
        
        return ejecutarSelect(procedimientoalmacenado);
    }
    
    public List<Supraevento> listarSupraeventosDeParticipante(int idParticipante, LocalDate desdeFecha, LocalDate hastaFecha){
        String procedimientoalmacenado 
                = String.format("{CALL sp_listarsupraeventosdeparticipante(%d, '%s', '%s')}"
                                , idParticipante, desdeFecha.toString(), hastaFecha.toString());
        
        return ejecutarSelect(procedimientoalmacenado);
    }
    
    public int insertarSupraevento(Supraevento supraevento){
        int idSupraevento = -1;
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL sp_insertarsupraevento(?,?,?,?)}";
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                cs.setString(1, supraevento.getNombreSupraevento());                
                cs.setDate(2, Date.valueOf(supraevento.getFechaInicio()));
                cs.setDate(3, Date.valueOf(supraevento.getFechaFin()));
                cs.setInt(4, supraevento.getEntradasDisponibles());
                
                try (ResultSet rs = cs.executeQuery();) {
                    if(rs.next()){
                        idSupraevento = rs.getInt("idSupraevento");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return idSupraevento;
    }
    
    private List<Supraevento> ejecutarSelect(String procedimientoalmacenado){
        List<Supraevento> supraeventos = new LinkedList<>();
        
        Connection cn = db.getConnection();
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                try (ResultSet rs = cs.executeQuery();) {
                    while(rs.next()){

                        Supraevento supraevento = new Supraevento();
                        supraevento.setIdSupraevento(rs.getInt("idSupraevento"));
                        supraevento.setNombreSupraevento(rs.getString("nombre_supraevento"));
                        supraevento.setFechaInicio(rs.getDate("fecha_inicio").toLocalDate());
                        supraevento.setFechaFin(rs.getDate("fecha_fin").toLocalDate());
                        supraevento.setEntradasDisponibles(rs.getInt("entradas_disponibles"));
                        supraevento.setNumeroInscritos(rs.getInt("numero_inscritos"));
                        supraevento.setEstadoSupraevento(rs.getString("estado_supraevento"));
                        
                        supraeventos.add(supraevento);

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                try{
                    cn.close();
                }catch(SQLException ex){
                    Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return supraeventos;
    }
}
