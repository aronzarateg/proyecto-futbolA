/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clacess;
//aron zarate gonzales
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aron//A.......
 *///ghfdgdfgd
public class Campeonato
{
     private int idcampeonato;
     private String nombre;
     private Date  fechaInicio;
     private Date fechaFin;

    public Campeonato() {
    }

    public Campeonato(int idcampeonato, String nombre, Date fechaInicio, Date fechaFin) {
        this.idcampeonato = idcampeonato;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(int idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    public static  Campeonato CargarCampeonato(ResultSet rs) throws SQLException
   {
       Campeonato cam= new Campeonato();
       cam.setIdcampeonato(rs.getInt("idCampeonato"));
      cam.setNombre(rs.getString("Nombre_campeonato"));
       cam.setFechaInicio(rs.getDate("Fecha_inicio"));
       cam.setFechaFin(rs.getDate("Fecha_fin"));
       
       return cam;
   }
}
