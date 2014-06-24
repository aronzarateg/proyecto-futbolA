/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Clacess.Equipo;
import Clacess.Presidente;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aron
 */
public class PresidenteDAO
{
     int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
     public ArrayList<Presidente> listarPresidente(){
        ArrayList<Presidente> lista = new ArrayList();
        sql = "select *from presidente";
         try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Presidente.loadPresidente(rs));
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: "+e);
         }
        
        return lista;
    }
      public int registrarPresidente(int idcampeonato,int idequipo,String nombre, String paterno,String materno,String dni,String sexo,String anNaci,String anDire,String Telefono ){
         try {
             sql="INSERT INTO presidente VALUES(null,'"+idcampeonato+"','"+idequipo+"','"+nombre+"','"+paterno+"','"+materno+"','"+dni+"','"+sexo+"','"+anNaci+"','"+anDire+"','"+Telefono+"')";
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error: "+e);
         }
         
    return res;
    }
       public int modificarPresidente(int idpresi,int idcam,int idequipo, String nombre, String paterno,String materno,String dni,String fecNac,String fechaDirect,String telefono){//ingresar tres valores y comprarlos con el id
    sql="UPDATE presidente set idCampeonato='"+idcam+"', idEquipo='"+idequipo+"',Nombre_pres='"+nombre+"',Ap_presidente='"+paterno+"',Am_presidente='"+materno+"',Dni='"+dni+"',Fec_Nac='"+fecNac+"',Fecha_presidente='"+fechaDirect+"',Telefono='"+telefono+"' WHERE idPresidente='"+idpresi+"'";
       
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
        public int eliminarPresidente(int ide){
        sql="DELETE FROM presidente WHERE idPresidente='"+ide+"'";
        try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
        public int buscarPresidente(String valor)
        {
            sql="SELECT * FROM predidente WHERE Nombre_pres='"+valor+"'";
            try {
                cx = Conexion.coneccion();
                st = cx.createStatement();
                rs = st.executeQuery(sql);
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Error: "+e);
            }
            
            
            
            
            return res;
            
        }
}
