package db.exercise.dao.mapper.boats;

import db.exercise.entities.boats.TransportState;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportStateMapper implements RowMapper<TransportState> {

	@Override
	public TransportState mapRow(ResultSet resultSet, int i) throws SQLException {
		TransportState state = new TransportState();
		state.setId(resultSet.getLong("id"));
		state.setTitle(resultSet.getString("title"));
		return state;
	}

}