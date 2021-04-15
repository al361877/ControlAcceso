package es.uji.ei1027.ControlAcceso.dao;


import es.uji.ei1027.ControlAcceso.model.EspacioPublico;
import es.uji.ei1027.ControlAcceso.model.Gestor;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public final class EspacioRowMapper implements RowMapper<EspacioPublico> {
    public EspacioPublico mapRow(ResultSet rs, int RowNum) throws SQLException{
        EspacioPublico espacioPublico = new EspacioPublico();
        espacioPublico.setId(rs.getString("id"));
        espacioPublico.setMunicipio(rs.getString("municipio"));
        espacioPublico.setTipo_espacio(rs.getString("tipo_espacio"));
        espacioPublico.setCp(rs.getInt("cp"));

        return espacioPublico;

    }
}