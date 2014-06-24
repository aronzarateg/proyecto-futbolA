/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Clacess.Jugador;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aron
 */
public class JugadorDAO
{
     int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
    
     public int registrarJugador(int idequipo,String nombre, String paterno,String materno,String anNacimiento,String posicion ){
     try {
         sql="INSERT INTO jugador VALUES(null,'"+idequipo+"','"+nombre+"','"+paterno+"','"+materno+"','"+posicion+"','"+anNacimiento+"')";
        cx = Conexion.coneccion();
        st = cx.createStatement();
        res = st.executeUpdate(sql);
     } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error: "+e);
     }

return res;
}
         
     public ArrayList<Jugador> listarJugador(){
        ArrayList<Jugador> lista = new ArrayList();
        sql = "select *from jugador";
         try {
             cx = Conexion.coneccion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Jugador.loadUsuario(rs));
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error: "+e);
         }
        
        return lista;
    }
      public int modificarJugador(int idjugador,int idequipo, String nombre, String paterno,String materno,String Pocision,String FechaNa ){//ingresar tres valores y comprarlos con el id
    sql="UPDATE jugador set idEquipo='"+idequipo+"', Nombre='"+nombre+"',ap_Jugador='"+paterno+"',am_Jugador='"+materno+"',Posicion='"+Pocision+"',Fecha_Nac='"+FechaNa+"' WHERE idJugador='"+idjugador+"'";
       
        try {
            cx = Conexion.coneccion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Error: "+e);
        }
    return res;
    }
    /*
    
    DefaultTableModel modelo;
    public int totalregistros;
    public DefaultTableModel mostrar (String buscar)
    {
        String[] titulos={"ID","id_Equipo","Equipo","Nombre","Ap Paterno","Ap Materno","Posicion","Fc.Nacimiento"};
        String [] registro= new String[8];
        totalregistros=0;
        modelo= new DefaultTableModel(null,titulos);
        sql="select j.idJugador,j.idEquipo,e.Nombre_equipo,j.Nombre,j.ap_Jugador,j.am_Jugador,j.Posicion,j.Fecha_Nac from jugador j inner join equipo e on j.idEquipo=e.idEquipo where j.Nombre like '%"+buscar+"%'order by idJugador  desc";
        try {
            st=cx.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                registro [0]=rs.getString("idJugador");
                registro [1]=rs.getString("id_Equipo");
                registro [2]=rs.getString("Nombre_equipo");
                registro [3]=rs.getString("Nombre");
                registro [4]=rs.getString("ap_Jugador");
                registro [5]=rs.getString("am_Jugador");
                registro [6]=rs.getString("Posicion");
                registro [7]=rs.getString("Fecha_Nac");
                totalregistros=totalregistros+1;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
       return null;
        }
       
    }
    public boolean insertar(Jugador dts)
    {
        sql="insert into jugador (idEquipo,Nombre,ap_Jugador,am_Jugador,Jugador,Fecha_Nac) values(?,?,?,?,?,?)";
         try {
             PreparedStatement pst=cx.prepareStatement(sql);
            
             pst.setInt(1,dts.getIdequipo());
             pst.setString(2,dts.getNombre());
             pst.setString(3,dts.getApellidop());
             pst.setString(4,dts.getApellidom());
             pst.setString(5,dts.getPosicion());
             pst.setDate(6 ,dts.getFechanaci());
             
             int n=pst.executeUpdate();
             if(n!=0)
             {
                 return true;
             }else{
                return false;
             }
         } catch (Exception ex) {
             JOptionPane.showConfirmDialog(null,ex);
             return false;
         }
    }
    public boolean  editar(Jugador  dts)
    {
        sql="update jugador set idEquipo=?,Nombre=?,ap_Jugador=?,am_Jugador=?,Posicion=?,Fecha_Nac=?  where idJugador=?";
        
        try {
             PreparedStatement pst=cx.prepareStatement(sql);
             
             pst.setInt(1,dts.getIdequipo());
             pst.setString(2,dts.getNombre());
             pst.setString(3,dts.getApellidop());
             pst.setString(4,dts.getApellidom());
             pst.setString(5,dts.getPosicion());
             pst.setDate(5,dts.getFechanaci());
             
             pst.setInt(7,dts.getIdjugador());
             
              int n=pst.executeUpdate();
             if(n!=0)
             {
                 return true;
             }else{
                return false;
             }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,e);
             return false;
        } 
    }
     public boolean eliminar (Jugador dts)
        {
           sql="delete from jugador=idJugador=?";
            try {
                PreparedStatement pst=cx.prepareStatement(sql);
                pst.setInt(1,dts.getIdjugador());
                int n=pst.executeUpdate();
             if(n!=0)
             {
                 return true;
             }else{
                return false;
             }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null,e);
                return false;
            }
        }
     */
}
