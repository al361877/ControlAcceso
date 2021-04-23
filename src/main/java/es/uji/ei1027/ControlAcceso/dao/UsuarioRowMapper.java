package es.uji.ei1027.ControlAcceso.dao;

import es.uji.ei1027.ControlAcceso.model.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class UsuarioRowMapper implements RowMapper<Usuario> {
    public Usuario mapRow(ResultSet rs, int RowNum) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setNombre(rs.getString("nombre_y_apellidos"));
        usuario.setDni(rs.getString("dni"));
        usuario.setUsuario(rs.getString("nombre_usuario"));
        usuario.setContraseña(rs.getString("contraseña"));
        usuario.setEmail(rs.getString("email"));
        usuario.setCiudad(rs.getString("ciudad"));
        usuario.setCalle(rs.getString("calle"));
        usuario.setCp(rs.getInt("cp"));
        usuario.setTelefono(rs.getString("telefono"));
        usuario.setNacimiento(rs.getString("nacimiento"));
        usuario.setTipoUsuario(rs.getString("tipo_usuario"));

        return usuario;

    }
}
