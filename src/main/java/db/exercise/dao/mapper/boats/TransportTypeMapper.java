package db.exercise.dao.mapper.boats;

import db.exercise.entities.boats.TransportType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportTypeMapper implements RowMapper<TransportType> {

	@Override
	public TransportType mapRow(ResultSet resultSet, int i) throws SQLException {
		TransportType type = new TransportType();
		type.setId(resultSet.getLong("id"));
		type.setTitle(resultSet.getString("title"));
		return type;
	}

}