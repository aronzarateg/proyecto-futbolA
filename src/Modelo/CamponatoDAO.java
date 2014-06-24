/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Clacess.Campeonato;
//import Conexion.Coneccion;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aron
 */
public class CamponatoDAO 
{
    int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    public ArrayList<Campeonato>  listarCampeonatos()
    {
        ArrayList<Campeonato> lista= new ArrayList();
        sql="SELECT * FROM campeonato";
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                lista.add(Campeonato.CargarCampeonato(rs));//llamamos a la clase usuarios y consu metodo cargarusuarios
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
        }
        
        return lista;
    }
     public int  retornarIDcampeonato(String cate)
     {
         int idcam=0;
         sql="SELECT *FROM campeonato WHERE Nombre_campeonato='"+cate+"'";
         
         try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            //cx.close();
            while(rs.next())
            {
                idcam=rs.getInt("idCampeonato");
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"ERROR"+e);
         }
         return idcam;
     }
     
      public int  verificarCampeonato(String  user )
    {
        sql="SELECT *FROM campeonato WHERE Nombre_campeonato='"+user+"'";
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
    
}
