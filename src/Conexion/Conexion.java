/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aron
 */
public class Conexion 
{
   /*
    public static Connection GetConexion() throws ClassNotFoundException, SQLException
    {
     Connection conex=null;
    
        
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/proyectofutbol";
            String usuario="root";
            String pass ="root";
            conex =(Connection) DriverManager.getConnection(url,usuario,pass);
            return conex;
        
     
    }
    */
    
    
   
    public static  Connection coneccion(){
         Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/proyectofutbol","root","root");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conexion;
    }
    
    
}
