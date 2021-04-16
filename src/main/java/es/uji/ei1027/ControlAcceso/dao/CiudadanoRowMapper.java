package es.uji.ei1027.ControlAcceso.dao;


import es.uji.ei1027.ControlAcceso.model.Ciudadano;
import es.uji.ei1027.ControlAcceso.model.Controlador;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public final class CiudadanoRowMapper implements RowMapper<Ciudadano> {
    public Ciudadano mapRow(ResultSet rs, int RowNum) throws SQLException{
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setNombre(rs.getString("nombre"));
        ciudadano.setDni(rs.getString("dni"));
        ciudadano.setUsuario(rs.getString("usuario"));
        ciudadano.setContraseña(rs.getString("contraseña"));
        ciudadano.setEmail(rs.getString("email"));
        ciudadano.setTelefono(rs.getString("telefono"));
        ciudadano.setNacimiento(rs.getDate("nacimiento"));
        ciudadano.setTipoUsuario(rs.getString("tipo_usuario"));

        return ciudadano;

    }
}