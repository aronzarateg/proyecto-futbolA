/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Modelo.Usuarios;
import java.util.ArrayList;

    
public class UsuarioDAO {
    int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    Usuarios u;
     public int ValidarUsuario(String USUARIO,String CLAVE)
    {
        sql="SELECT  * FROM  usuario WHERE  usuario='"+USUARIO+"' AND clave='"+CLAVE+"'";
        try {
            cx = Conexion.coneccion(); 
            st=cx.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next())
            {
                res=1;
            }else{
                res=2;
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERROR"+ex);
        }
        return res;
    }
     //--------------------------------------------------------------------------------
     public int  verificarUsuario(String  user )
    {
        sql="SELECT *FROM usuario WHERE usuario='"+user+"'";
        try { 
              cx=Conexion.coneccion();
              st=cx.createStatement();
              rs=st.executeQuery(sql);
              if(rs.next())
            {
                res=1;
                 //JOptionPane.showMessageDialog(null,"YA EXISTE ESE USUARIO");
            }else{
                res=2;
               // JOptionPane.showMessageDialog(null,"USUARIO GUARDADO EXITOSAMENTE");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR"+ex);
        }
        return res;   
    }
//--------------------------------------------------------------------------------
    public int registrarUsuario(String user,String clave)
    {
        try {        
            cx = Conexion.coneccion();
            PreparedStatement pst = null;
            pst = cx.prepareStatement("INSERT INTO usuario VALUES ('"+user+"','"+clave+"') " );
//            pst.setString(1, u.getUsuario());
  //          pst.setString(2, u.getClave());
            //pst.setInt(3, u.getEmpleado().getNroEmpleado());
    //        pst.executeUpdate();
      ////      cx.close();
          //  pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
      public ArrayList<Usuarios> listarUsuario(){
        ArrayList<Usuarios> lista = new ArrayList();
        sql = "select *from usuario";
          try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuarios.loadUsuario(rs));
            
            }
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error: "+e);
          }
        return lista;
    }
    public int modificarUsuario(int idusuario, String usuario, String clave ){//ingresar tres valores y comprarlos con el id
    sql="UPDATE usuario set  usuario='"+usuario+"',clave='"+clave+"' WHERE idUsuario='"+idusuario+"'";
       
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
    //-----------------------------------------------------------------------------------
    
    
    
    public int eliminarUsuario(int idu){
        sql="DELETE FROM Usuario WHERE idUsuario='"+idu+"'";
        try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
    public ArrayList<Usuarios> listarUsuariod(int id){
        ArrayList<Usuarios> lista = new ArrayList();
        sql = "select *from Usuario WHERE idUsuario="+id;
        try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuarios.loadUsuario(rs));
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        return lista;
    } 
    public ArrayList<Usuarios> listarUsuario(String us){
    ArrayList<Usuarios> lista = new ArrayList();
        sql = "select *from Usuario WHERE usuario LIKE '"+us+"'%";
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuarios.loadUsuario(rs));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }

    
}
