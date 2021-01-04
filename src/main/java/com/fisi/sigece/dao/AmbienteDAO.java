/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import com.fisi.sigece.modelos.Ambiente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CUS 05 - Registrar ambiente
 * @author josecarlos
 */
public class AmbienteDAO {
    
   private AccesoDB db; 
   
   public AmbienteDAO(){
       db = new AccesoDB();
   }
   
   public List<Ambiente> listarAmbientes(){
        List<Ambiente> lista = new ArrayList<>();
        String procedimientoalmacenado = "{CALL sp_listarambientes()}";
        Connection cn = db.getConnection();
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                try (ResultSet rs = cs.executeQuery();) {
                
                    while(rs.next()){
                        Ambiente amb = new Ambiente();
                        amb.setIdAmbiente(rs.getInt("idAmbiente"));
                        amb.setNombreAmbiente(rs.getString("nombreAmbiente"));
                        amb.setCapacidad(rs.getInt("capacidad"));                                   
                        lista.add(amb);
                    }
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lista;
}
   public Ambiente obtenerAmbiente(int idAmbiente){
        Ambiente ambiente = null;
        String procedimientoalmacenado = "{CALL sp_obtenerambiente(?)}";
        Connection cn = db.getConnection();
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setInt(1, idAmbiente);
                
                try (ResultSet rs = cs.executeQuery();) {
                    if(rs.next()){
                        ambiente = new Ambiente();
                        ambiente.setIdAmbiente(rs.getInt("idAmbiente"));
                        ambiente.setNombreAmbiente(rs.getString("nombreAmbiente"));
                        ambiente.setCapacidad(rs.getInt("capacidad"));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ambiente;
}
   
   public String insertarAmbiente (Ambiente ambiente) {
        String rpta = null;
        String procedimientoalmacenado="{CALL sp_insertarambiente(?,?)}";
        Connection cn = db.getConnection();
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setString(1, ambiente.getNombreAmbiente());
                cs.setInt(2, ambiente.getCapacidad());                
                int inserto = cs.executeUpdate();
                
                if(inserto == 0){
                    rpta="Error";
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rpta;
    } 
   
    public String actualizarAmbiente (Ambiente ambiente) {
        String rpta = null;
        String procedimientoalmacenado = "{CALL sp_actualizarambiente (?,?,?)}";
        Connection cn = db.getConnection();
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setInt(1, ambiente.getIdAmbiente());
                cs.setString(2, ambiente.getNombreAmbiente());
                cs.setInt(3, ambiente.getCapacidad());        
                
                int actualizo = cs.executeUpdate();
                
                if(actualizo == 0){
                    rpta = "Error";
                }
            } catch (SQLException ex) {
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        return rpta;
    }
    
    public String eliminarAmbiente(int idAmbiente) {
        String rpta = null;
        String procedimientoalmacenado = "{CALL sp_eliminarAmbiente(?)}";
        Connection cn = db.getConnection();
        
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setInt(1, idAmbiente);
                cs.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(AmbienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return rpta;
    }
    
    public int obtenerIdambienteDeNombre(String nombreAmbiente){
        int idambiente = -1;
        String funcionalmacenada = "{? = CALL fu_obteneridambientedenombre(?)}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(funcionalmacenada)){
            
                cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
                
                cs.setString(2, nombreAmbiente);
                cs.execute();
                idambiente = cs.getInt(1);
                
            } catch (SQLException ex) {
                Logger.getLogger(OtrasFuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(OtrasFuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return idambiente;
    } 
}
