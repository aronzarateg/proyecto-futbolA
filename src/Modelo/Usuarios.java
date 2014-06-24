/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aron
 */
public  class Usuarios 
{
    private int idusuario; 
     private String usuario;
    private String clave;

    public Usuarios() {
    }

    public Usuarios(int idusuario, String usuario, String clave) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
     public static Usuarios loadUsuario(ResultSet rs) throws SQLException{
		Usuarios usuario = new Usuarios();
                usuario.setIdusuario(rs.getInt("idUsuario"));
		usuario.setUsuario(rs.getString("usuario"));
		usuario.setClave(rs.getString("clave"));
		return usuario;
	}
}
