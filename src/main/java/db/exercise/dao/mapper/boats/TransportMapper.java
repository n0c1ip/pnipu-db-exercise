package db.exercise.dao.mapper.boats;

import db.exercise.entities.boats.Transport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportMapper implements RowMapper<Transport> {

	@Override
	public Transport mapRow(ResultSet resultSet, int i) throws SQLException {
		Transport transport = new Transport();
		transport.setId(resultSet.getLong("id"));
		transport.setTitle(resultSet.getString("title"));
		transport.setNumber(resultSet.getString("number"));
		transport.setState(resultSet.getLong("state"));
		transport.setType(resultSet.getLong("type"));
		transport.setAvailability(resultSet.getBoolean("availability"));
		return transport;
	}

}