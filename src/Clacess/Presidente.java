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
public class Presidente 
{
    private int idpresidente;
    private int idcampeonato;
    private int idequipo;
    private String nombre;
    private String paterno;
    private String materno;
    private String dni;
    private String sexo;
    private Date  fechanaci; 
    private Date  fechapresi;
    private String  telefono;  

    public Presidente() {
    }

/*
    public Presidente(int idpresidente, int idcampeonato, int idequipo, String nombre, String paterno, String materno, String dni, String sexo, Date fechanaci, Date fechapresi, String telefono) {
    this.idpresidente = idpresidente;
    this.idcampeonato = idcampeonato;
    this.idequipo = idequipo;
    this.nombre = nombre;
    this.paterno = paterno;
    this.materno = materno;
    this.dni = dni;
    this.sexo = sexo;
    this.fechanaci = fechanaci;
    this.fechapresi = fechapresi;
    this.telefono = telefono;
    }*/
    public Presidente(int idcampeonato, int idequipo, String nombre, String paterno, String materno, String dni, String sexo, Date fechanaci, Date fechapresi, String telefono) {
        this.idcampeonato = idcampeonato;
        this.idequipo = idequipo;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.dni = dni;
        this.sexo = sexo;
        this.fechanaci = fechanaci;
        this.fechapresi = fechapresi;
        this.telefono = telefono;
    }
    
    public int getIdpresidente() {
        return idpresidente;
    }

    public void setIdpresidente(int idpresidente) {
        this.idpresidente = idpresidente;
    }

    public int getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(int idcampeonato) {
        this.idcampeonato = idcampeonato;
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

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(Date fechanaci) {
        this.fechanaci = fechanaci;
    }

    public Date getFechapresi() {
        return fechapresi;
    }

    public void setFechapresi(Date fechapresi) {
        this.fechapresi = fechapresi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     public static Presidente loadPresidente(ResultSet rs) throws SQLException{
		Presidente presi = new Presidente();
                presi.setIdpresidente(rs.getInt("idPresidente"));
		presi.setIdcampeonato(rs.getInt("idCampeonato"));
                presi.setIdequipo(rs.getInt("idEquipo"));
                presi.setNombre(rs.getString("Nombre_pres"));
                presi.setPaterno(rs.getString("Ap_presidente"));
                presi.setMaterno(rs.getString("Am_presidente"));
                presi.setDni(rs.getString("Dni"));
                presi.setSexo(rs.getString("Sexo"));
                presi.setFechanaci(rs.getDate("Fec_Nac"));
                presi.setFechapresi(rs.getDate("Fecha_presidente"));
		presi.setTelefono(rs.getString("Telefono"));
		return presi;
	} 
}
