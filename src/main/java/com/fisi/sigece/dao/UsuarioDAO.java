/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fisi.sigece.dao;

import com.fisi.sigece.modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CUS 01 - Ingreso al sistema
 * @author josecarlos
 */
public class UsuarioDAO {
    private AccesoDB db; 
    
    public UsuarioDAO(){
        db = new AccesoDB();
    }
    
    public Usuario obtenerUsuario(String nombreUsuario, String contrasenia){
        Usuario usuario = null;
        String procedimientoalmacenado = "{CALL sp_autenticarusuario(?, ?)}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                cs.setString(1, nombreUsuario);
                cs.setString(2, contrasenia);
                    
                try (ResultSet rs = cs.executeQuery();) {
                    if(rs.next()){
                        usuario = new Usuario();
                        usuario.setIdUsuario(rs.getInt("idUsuario"));
                        usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                        if(rs.getString("tipo_usuario").equals("ADMIN")){
                            usuario.setTipoUsuario(Usuario.TipoUsuario.ADMIN);
                        }else if(rs.getString("tipo_usuario").equals("PARTICIPANTE")){
                            usuario.setTipoUsuario(Usuario.TipoUsuario.PARTICIPANTE);
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return usuario;
    }
    
    public String registrarParticipante(String nombreUsuario, String contrasenia, String nombrePersona){
        String rpta = null;
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL sp_registrarparticipante(?, ?, ?)}";
        
        if(cn!=null){
            try(CallableStatement cs = cn.prepareCall(procedimientoalmacenado)){
                
                cs.setString(1, nombreUsuario);
                cs.setString(2, contrasenia);
                cs.setString(3, nombrePersona);
                
                int inserto = cs.executeUpdate();
                
                if(inserto == 0){
                    rpta = "Error";
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException sqlEx){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, sqlEx);
            }
        }
        
        return rpta;
    }
    
    public boolean existeNombreUsuario(String nombreUsuario){
        boolean existeUsuario = false;
        String funcionalmacenada = "{? = CALL fu_verificarexistenciausuario(?)}";
        Connection cn = db.getConnection();
        
        if(cn != null){
            try(CallableStatement cs = cn.prepareCall(funcionalmacenada)){
            
                cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
                
                cs.setString(2, nombreUsuario);
                cs.execute();
                existeUsuario = cs.getBoolean(1);
                
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                cn.close();
            }catch(SQLException ex){
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        return existeUsuario;
    }
}
