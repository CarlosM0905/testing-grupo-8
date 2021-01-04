/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import com.fisi.sigece.modelos.Evento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CUS 04 - Crear evento
 * CUS 07 - Visulizar evento
 * @author josecarlos
 */
public class EventoDAO {
    
    private AccesoDB db; 
   
    public EventoDAO(){
       db = new AccesoDB();
    }
   
    public List<Evento> listarEventos(){
        String query = "{CALL sp_listarevento()}";
        return ejecutarSelectQuery(query);
    }
    
    public List<Evento> listarProximosEventos(){
        String query = "{CALL sp_listareventosproximos()}";
        return ejecutarSelectQuery(query);
    }
    
    public List<Evento> listarActualesEventos(){
        String query = "{CALL sp_listareventosactuales()}";
        return ejecutarSelectQuery(query);
    }
    
    public List<Evento> listarEventosDeSupraevento(int idSupraevento){
        String query = "{CALL sp_listareventosdesupraevento( "+ idSupraevento + ")}";
        return ejecutarSelectQuery(query);
    }
    
    private List<Evento> ejecutarSelectQuery(String query){
        ArrayList<Evento> lista = new ArrayList<>();
        String procedimientoalmacenado = query;
        
        Connection cn = db.getConnection();
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                try (ResultSet rs = cs.executeQuery();) {
                    while(rs.next()){

                        Evento evento=new Evento();
                        evento.setIdEvento(rs.getInt("idEvento"));
                        evento.setNombreEvento(rs.getString("nombre_evento"));
                        evento.setFechaEvento(rs.getDate("fecha_evento").toLocalDate());
                        evento.setHoraInicio(rs.getTime("hora_inicio_evento").toLocalTime());
                        evento.setHoraFin(rs.getTime("hora_fin_evento").toLocalTime());                                    
                        evento.setIdambiente(rs.getInt("Ambiente_idAmbiente"));
                        evento.setIdexpositor(rs.getInt("Expositor_id_expositor"));
                        evento.setEstadoEvento(rs.getString("estado_evento"));
                        evento.setNumeroInscritos(rs.getInt("numero_inscritos"));

                        lista.add(evento);

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
        return lista;
    }
   
    public List<Evento> listarProximosEventosDeParticipante(int idParticipante){
        String query = "{CALL sp_listareventosproximosparticipante(" + idParticipante + ")}";
        return ejecutarSelectQuery(query);
    }
    
    public Evento obtenerEvento(int idEvento){
        String query="{CALL sp_obtenerevento(" + idEvento + ")}";
        List<Evento> eventos = ejecutarSelectQuery(query);
        return  eventos.isEmpty() ? null : eventos.get(0);
    }
   
   public String insertarEvento (Evento evento){
        String rpta = null;
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL sp_insertarevento(?,?,?,?,?,?,?)}";
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                cs.setString(1,evento.getNombreEvento());                
                cs.setString(2, evento.getFechaEvento());
                cs.setTime(3, Time.valueOf(evento.getHoraInicio()));
                cs.setTime(4, Time.valueOf(evento.getHoraFin()));
                cs.setInt(5, evento.getIdambiente());
                cs.setInt(6, evento.getIdexpositor());
                cs.setInt(7, evento.getIdSupraevento());
                                            
                int inserto = cs.executeUpdate();
                
                if(inserto == 0){
                    rpta="Error";
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
        return rpta;
    }
   
   
}