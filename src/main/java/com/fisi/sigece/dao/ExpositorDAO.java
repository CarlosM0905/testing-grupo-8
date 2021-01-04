/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import com.fisi.sigece.modelos.Expositor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CUS 02 - Registrar al expositor
 * CUS 03 - Modificar expositor
 * @author josecarlos
 */
public class ExpositorDAO {
    
private AccesoDB db; 

    public ExpositorDAO(){
       db = new AccesoDB();
    }
   
   public List<Expositor> listarExpositores(){
        List<Expositor> lista = new ArrayList<>();
        String procedimientoalmacenado = "{CALL sp_listarExpositores()}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                try (ResultSet rs = cs.executeQuery();) {
                    while(rs.next()){                    
                        Expositor exp=new Expositor();
                        exp.setIdExpositor(rs.getInt("id_expositor"));
                        exp.setNombreExpositor(rs.getString("nombre_expositor"));
                        exp.setEspecialidadExpositor(rs.getString("especialidad_expositor"));
                        exp.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                        exp.setCorreoExpositor(rs.getString("correo_expositor"));                                
                        lista.add(exp);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
}
   public Expositor obtenerExpositor(int idExpositor){
        Expositor expositor = null;
        String procedimientoalmacenado = "{CALL sp_obtenerexpositor(?)}";
        Connection cn = db.getConnection();
        
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setInt(1, idExpositor);
                
                try (ResultSet rs = cs.executeQuery();) {
                    if(rs.next()){
                        expositor = new Expositor();
                        expositor.setIdExpositor(rs.getInt("id_expositor"));
                        expositor.setNombreExpositor(rs.getString("nombre_expositor"));
                        expositor.setEspecialidadExpositor(rs.getString("especialidad_expositor"));
                        expositor.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                        expositor.setCorreoExpositor(rs.getString("correo_expositor"));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return expositor;
}
   
   public String insertarExpositor (Expositor expositor) {
        String rpta = null;
        String procedimientoalmacenado="{CALL sp_insertarexpositor(?,?,?,?)}";
        Connection cn = db.getConnection();
        
        if(cn!=null){
            
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
            
                cs.setString(1,expositor.getNombreExpositor());
                cs.setString(2,expositor.getEspecialidadExpositor()); 
                cs.setString(3,expositor.getFechaNacimiento()); 
                cs.setString(4,expositor.getCorreoExpositor()); 
                int inserto=cs.executeUpdate();
                
                if(inserto==0){
                    rpta="Error";
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rpta;
    }
   
    public String actualizarExpositores (Expositor expositor) {
        String rpta = null;
        String procedimientoalmacenado = "{CALL sp_actualizarexpositor (?,?,?,?,?)}";
        Connection cn = db.getConnection();
        
        if(cn!=null){
            
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
            
                cs.setInt(1, expositor.getIdExpositor());
                cs.setString(2, expositor.getNombreExpositor());
                cs.setString(3, expositor.getEspecialidadExpositor()); 
                cs.setString(4, expositor.getFechaNacimiento()); 
                cs.setString(5, expositor.getCorreoExpositor());         
                
                int actualizo = cs.executeUpdate();
                
                if(actualizo == 0){
                    rpta = "Error";
                }
            } catch (SQLException ex) {
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rpta;
    }
    
    public String eliminarExpositores (int idExpositor) {
        String rpta = null;
        String procedimientoalmacenado = "{CALL sp_eliminarexpositor(?)}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setInt(1, idExpositor);
                cs.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(ExpositorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rpta;
    }
    
    public int obtenerIdexpositorDeNombre(String nombreExpositor){
        int idexpositor = -1;
        String funcionalmacenada = "{? = CALL fu_obteneridexpositordenombre(?)}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(funcionalmacenada)){
            
                cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
                
                cs.setString(2, nombreExpositor);
                cs.execute();
                idexpositor = cs.getInt(1);
                
            } catch (SQLException ex) {
                Logger.getLogger(OtrasFuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(OtrasFuncionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return idexpositor;
    } 
}