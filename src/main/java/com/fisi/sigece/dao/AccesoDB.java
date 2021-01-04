package com.fisi.sigece.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elvis
 */
public class AccesoDB {
    
    public Connection getConnection(){
        Connection connection = null;
        try{
            //CONEXION DIRECTA
            DriverManager.registerDriver(
                new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sigese?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "password");
            
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
  
}
