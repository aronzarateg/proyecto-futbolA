/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Clacess.Equipo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aron
 */
public class EquipoDAO 
{
     int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
    public int  verificarEquipo(String  equi )
    {
        sql="SELECT *FROM equipo WHERE Nombre_equipo='"+equi+"'";
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
    
    public ArrayList<Equipo> listarEquipo(){
        ArrayList<Equipo> lista = new ArrayList();
        sql = "select *from equipo";
         try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Equipo.loadEquipo(rs));
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: "+e);
         }
        
        return lista;
    }
     public int registrarEquipo(int idcampeonato,String nombre, String estadio,String anFundacion,String ciudad ){
         try {
             sql="INSERT INTO equipo VALUES(null,'"+idcampeonato+"','"+nombre+"','"+estadio+"','"+anFundacion+"','"+ciudad+"')";
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error: "+e);
         }
         
    return res;
    }
     public int modificarEquipo(int ide,int idcam, String nombre, String estadio,String fecfun,String ciudad){//ingresar tres valores y comprarlos con el id
    sql="UPDATE equipo set idCampeonato='"+idcam+"', Nombre_equipo='"+nombre+"',Nombre_Estadio='"+estadio+"',An_Fundacion='"+fecfun+"',Ciudad='"+ciudad+"' WHERE idEquipo='"+ide+"'";
       
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
      public int eliminarEquipo(int ide){
        sql="DELETE FROM equipo WHERE idEquipo='"+ide+"'";
        try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
      
       public int  retornarIDEquipo(String cate)
     {
         int ideq=0;
         sql="SELECT *FROM equipo WHERE Nombre_equipo='"+cate+"'";
         
         try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            //cx.close();
            while(rs.next())
            {
                ideq=rs.getInt("idEquipo");
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"ERROR"+e);
         }
         return ideq;
     }
}
