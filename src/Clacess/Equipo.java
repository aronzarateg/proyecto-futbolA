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
public class Equipo 
{
    private String idequipo;
    private String nombre;
    private String estadio;
    private String campeonato;
    private String ciudad;
    private Date  fechafunda;

    public Equipo() {
    }

    public Equipo(String idequipo, String nombre, String estadio, String campeonato, String ciudad, Date fechafunda) {
        this.idequipo = idequipo;
        this.nombre = nombre;
        this.estadio = estadio;
        this.campeonato = campeonato;
        this.ciudad = ciudad;
        this.fechafunda = fechafunda;
    }

    public String getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(String idequipo) {
        this.idequipo = idequipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechafunda() {
        return fechafunda;
    }

    public void setFechafunda(Date fechafunda) {
        this.fechafunda = fechafunda;
    }
    
     public static Equipo loadEquipo(ResultSet rs) throws SQLException{
		Equipo equipo = new Equipo();
                equipo .setIdequipo(rs.getString("idEquipo"));
		equipo .setCampeonato(rs.getString("idCampeonato"));
                equipo .setNombre(rs.getString("Nombre_equipo"));
                equipo .setEstadio(rs.getString("Nombre_Estadio"));
                equipo .setFechafunda(rs.getDate("An_Fundacion"));
                equipo .setCiudad(rs.getString("Ciudad"));
		//equipo .setFechanaci(rs.getDate("Fecha_Nac"));
		return equipo ;
	}
}
