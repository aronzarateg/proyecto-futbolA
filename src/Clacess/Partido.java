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
 * @author aron
 */
public class Partido 
{
    
    
     private int idpartido;
    private int idequipo;
    private int idcampeonato;
    private int golcasa;
    private int golvisita;
    private Date  fechapart; 

    public Partido() {
    }

/*
    public Partido(int idpartido, int idequipo, int idcampeonato, int golcasa, int golvisita, Date fechapart) {
    this.idpartido = idpartido;
    this.idequipo = idequipo;
    this.idcampeonato = idcampeonato;
    this.golcasa = golcasa;
    this.golvisita = golvisita;
    this.fechapart = fechapart;
    }
     */
    public Partido(int idequipo, int idcampeonato, int golcasa, int golvisita, Date fechapart) {
        this.idequipo = idequipo;
        this.idcampeonato = idcampeonato;
        this.golcasa = golcasa;
        this.golvisita = golvisita;
        this.fechapart = fechapart;
    }
    
    
    public int getIdpartido() {
        return idpartido;
    }

    public void setIdpartido(int idpartido) {
        this.idpartido = idpartido;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public int getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(int idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public int getGolcasa() {
        return golcasa;
    }

    public void setGolcasa(int golcasa) {
        this.golcasa = golcasa;
    }

    public int getGolvisita() {
        return golvisita;
    }

    public void setGolvisita(int golvisita) {
        this.golvisita = golvisita;
    }

    public Date getFechapart() {
        return fechapart;
    }

    public void setFechapart(Date fechapart) {
        this.fechapart = fechapart;
    }
    public static Partido loadPartido(ResultSet rs) throws SQLException{
		Partido parti = new Partido();
                parti.setIdpartido(rs.getInt("idPartido"));
		parti.setIdequipo(rs.getInt("idEquipo"));
                parti.setIdcampeonato(rs.getInt("idCampeonato"));
                parti.setGolcasa(rs.getInt("Gol_Casa"));
                parti.setGolvisita(rs.getInt("Gol_Visita"));
                parti.setFechapart(rs.getDate("Fecha_partido"));
                
		return parti;
	} 
}
