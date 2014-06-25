/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clacess;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aron
 */
public class JugadorCampeonato 
{
    private int idjugador;
    private int idcampeonato;
    private int tarjroja;
    private int tarjamarilla;

    public JugadorCampeonato() {
    }

    public JugadorCampeonato(int tarjroja, int tarjamarilla) {
        this.tarjroja = tarjroja;
        this.tarjamarilla = tarjamarilla;
    }

    

    

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }

    public int getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(int idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public int getTarjroja() {
        return tarjroja;
    }

    public void setTarjroja(int tarjroja) {
        this.tarjroja = tarjroja;
    }

    public int getTarjamarilla() {
        return tarjamarilla;
    }

    public void setTarjamarilla(int tarjamarilla) {
        this.tarjamarilla = tarjamarilla;
    }
    public static  JugadorCampeonato CargarJugadorCampeonato(ResultSet rs) throws SQLException
   {
       JugadorCampeonato jcam= new JugadorCampeonato();
       jcam.setIdjugador(rs.getInt("idJugador"));
      jcam.setIdcampeonato(rs.getInt("idCampeonato"));
       jcam.setTarjroja(rs.getInt("Targeta_roja"));
       jcam.setTarjamarilla(rs.getInt("Targeta_amarilla"));
       
       return jcam;
   }
}
