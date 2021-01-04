/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import com.fisi.sigece.modelos.Inscripcion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CUS 06 - Visulizar asistencia a un evento
 * CUS 07 - Registrar asistencia a un evento
 * CUS 06 - Cancelar asistencia a un evento
 * @author josecarlos
 */
public class InscripcionDAO {
    
    private AccesoDB db; 
   
    public InscripcionDAO(){
       db = new AccesoDB();
    }
    
    public List<Inscripcion> listarInscripcionesDeParticipante(int idParticipante){
        String procedimientoalmacenado = String.format("{CALL sp_listarinscripcionesdeparticipante(%d)}", idParticipante);
        return ejecutarSelect(procedimientoalmacenado);
    }
    
    public List<Inscripcion> listarInscripcionesDeSupraevento(int idEvento){
        String procedimientoalmacenado = String.format("{CALL sp_listarinscripcionesdeevento(%d)}", idEvento);
        return ejecutarSelect(procedimientoalmacenado);
    }
    
    public boolean estaParticipanteInscritoEnSupraevento(int idSupraevento, int idParticipante){
        boolean estaInscrito = false;
        String procedimientoalmacenado = "{? = CALL fu_estainscrito(?, ?)}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                cs.registerOutParameter(1,java.sql.Types.BOOLEAN);

                cs.setInt(2, idSupraevento);
                cs.setInt(3, idParticipante);
                cs.execute();
                estaInscrito = cs.getBoolean(1);
                
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return estaInscrito;
    }
    
    public String registrarInscripcionEnSupraevento(Inscripcion inscripcion){
        String procedimientoalmacenado = "{CALL sp_registrarinscripcion(?,?)}";
        return ejectuarUpdate(procedimientoalmacenado, inscripcion);
    }
    
    public String anularInscripcionEnSupraevento(Inscripcion inscripcion){
        String procedimientoalmacenado = "{CALL sp_eliminarinscripcion(?,?)}";
        return ejectuarUpdate(procedimientoalmacenado, inscripcion);
    }
    
    private List<Inscripcion> ejecutarSelect(String procedimientoalmacenado){
        List<Inscripcion> lista = new LinkedList<>();
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                try (ResultSet rs = cs.executeQuery();) {
                    while(rs.next()){

                        Inscripcion inscripcion = new Inscripcion();
                        inscripcion.setIdSupraevento(rs.getInt("Evento_idEvento"));
                        inscripcion.setIdParticipante(rs.getInt("Participante_idPersona"));
                        inscripcion.setNombreEvento(rs.getString("nombre_evento"));
                        inscripcion.setNombreParticipante(rs.getString("nombre_persona"));
                        
                        lista.add(inscripcion);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    }
    
    private String ejectuarUpdate(String procedimientoalmacenado, Inscripcion inscripcion){
        String rpta = null;
        
        Connection cn = db.getConnection();
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setInt(1, inscripcion.getIdSupraevento());                
                cs.setInt(2, inscripcion.getIdParticipante());
                
                int inserto = cs.executeUpdate();
                
                if(inserto == 0){
                    rpta = "Error";
                }
            } catch (SQLException ex) {
                Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException sqlEx){
                Logger.getLogger(InscripcionDAO.class.getName()).log(Level.SEVERE, null, sqlEx);
            }
        }
        return rpta;
    }
}
