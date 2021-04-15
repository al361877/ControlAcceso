package es.uji.ei1027.ControlAcceso.dao;


import es.uji.ei1027.ControlAcceso.model.Gestor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public final class GestorRowMapper implements RowMapper<Gestor> {
    public Gestor mapRow(ResultSet rs, int RowNum) throws SQLException{
        Gestor gestor = new Gestor();
        gestor.setNombre(rs.getString("nombre"));
        gestor.setDni(rs.getString("dni"));
        gestor.setUsuario(rs.getString("usuario"));
        gestor.setContraseña(rs.getString("contraseña"));
        gestor.setEmail(rs.getString("email"));
        gestor.setTelefono(rs.getInt("telefono"));

        return gestor;

    }
}