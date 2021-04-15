package es.uji.ei1027.ControlAcceso.dao;


import es.uji.ei1027.ControlAcceso.model.Estacion;
import es.uji.ei1027.ControlAcceso.model.Reserva;
import es.uji.ei1027.ControlAcceso.model.Servicio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public final class EstacionRowMapper implements RowMapper<Estacion> {
    public Estacion mapRow(ResultSet rs, int RowNum) throws SQLException{
        Estacion estacion = new Estacion();
        estacion.setId(rs.getString("id"));
        estacion.setFechaFin(rs.getDate("fechaini"));
        estacion.setFechaFin(rs.getDate("fechafin"));
        return estacion;

    }
}