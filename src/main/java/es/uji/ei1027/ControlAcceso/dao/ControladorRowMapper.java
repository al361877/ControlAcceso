package es.uji.ei1027.ControlAcceso.dao;


import es.uji.ei1027.ControlAcceso.model.Controlador;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public final class ControladorRowMapper implements RowMapper<Controlador> {
    public Controlador mapRow(ResultSet rs, int RowNum) throws SQLException{
        Controlador controlador = new Controlador();
        controlador.setNombre(rs.getString("nombre"));
        controlador.setDni(rs.getString("dni"));
        controlador.setUsuario(rs.getString("usuario"));
        controlador.setContraseña(rs.getString("contraseña"));
        controlador.setEmail(rs.getString("email"));
        controlador.setTelefono(rs.getString("telefono"));
        controlador.setNacimiento(rs.getDate("nacimiento"));
        controlador.setTipoUsuario(rs.getString("tipo_usuario"));

        return controlador;

    }
}