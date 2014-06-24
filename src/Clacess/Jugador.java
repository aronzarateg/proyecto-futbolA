/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clacess;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aron
 */
public   class Jugador
{   
   private int idjugador;
   private int idequipo;
   private String nombre;
   private String apellidop;
   private String apellidom;
   private String posicion;
   private Date  fechanaci;

    public Jugador() {
    }

    /*
    public Jugador(int idjugador, int idequipo, String nombre, String apellidop, String apellidom, String posicion, Date fechanaci) {
        this.idjugador = idjugador;
        this.idequipo = idequipo;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.posicion = posicion;
        this.fechanaci = fechanaci;
    }
    */

    public Jugador(int idequipo, String nombre, String apellidop, String apellidom, String posicion, Date fechanaci) {
        this.idequipo = idequipo;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.posicion = posicion;
        this.fechanaci = fechanaci;
    }


    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Date getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(Date fechanaci) {
        this.fechanaci = fechanaci;
    }
    
    public static Jugador loadUsuario(ResultSet rs) throws SQLException{
		Jugador usuario = new Jugador();
                usuario.setIdjugador(rs.getInt("idJugador"));
		usuario.setIdequipo(rs.getInt("idEquipo"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellidop(rs.getString("ap_Jugador"));
                usuario.setApellidom(rs.getString("am_Jugador"));
                usuario.setPosicion(rs.getString("Posicion"));
		usuario.setFechanaci(rs.getDate("Fecha_Nac"));
		return usuario;
	} 
}
