/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Clacess.JugadorCampeonato;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aron
 */
public class JugCampDAO 
{
     int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    public ArrayList<JugadorCampeonato>  listarCampeonatos()
    {
        ArrayList<JugadorCampeonato> lista= new ArrayList();
        sql="SELECT * FROM jugador_has_campeonato";
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next())
            {
                lista.add(JugadorCampeonato.CargarJugadorCampeonato(rs));//llamamos a la clase usuarios y consu metodo cargarusuarios
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
      public int  retornarIDjugador(String cate)
     {
         int idcam=0;
         sql="SELECT *FROM jugador WHERE Nombre='"+cate+"'";
         
         try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            //cx.close();
            while(rs.next())
            {
                idcam=rs.getInt("idJugador");
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"ERROR"+e);
         }
         return idcam;
     }
       public int registrarJugCampe(int idj,int idc,int roja, int amarillo ){
         try {
             sql="INSERT INTO jugador_has_campeonato VALUES(null,'"+idj+"','"+idc+"','"+roja+"','"+amarillo+"')";
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error: "+e);
         }
         
    return res;
    }
    
}
