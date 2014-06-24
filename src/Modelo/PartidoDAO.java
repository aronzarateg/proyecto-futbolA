/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Clacess.Partido;
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
public class PartidoDAO
{
    int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
     public ArrayList<Partido> listarPartido(){
        ArrayList<Partido> lista = new ArrayList();
        sql = "select *from partido";
         try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Partido.loadPartido(rs));
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: "+e);
         }
        
        return lista;
    }
   public int registrarPartido(int idequipo,int idcampeonato ,int Golcasa, int Golvisita,String anNaci ){
         try {
             sql="INSERT INTO partido VALUES(null,'"+idequipo+"','"+idcampeonato+"','"+Golcasa+"','"+Golvisita+"','"+anNaci+"')";
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Error: "+e);
         }
         
    return res;
    }
   public int modificarPartido(int idpartido,int idequipo,int idcampeonato, int golcasa, int golvisita,String FechaPartido){//ingresar tres valores y comprarlos con el id
    sql="UPDATE partido set idEquipo='"+idequipo+"', idCampeonato='"+idcampeonato+"',Gol_Casa='"+golcasa+"',Gol_Visita='"+golvisita+"',Fecha_partido='"+FechaPartido+"' WHERE idPartido='"+idpartido+"'";
       
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
}
