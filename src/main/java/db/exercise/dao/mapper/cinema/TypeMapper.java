package db.exercise.dao.mapper.cinema;

import db.exercise.entities.cinema.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeMapper implements RowMapper<Type> {

	@Override
	public Type mapRow(ResultSet resultSet, int i) throws SQLException {
		Type type = new Type();
		type.setId(resultSet.getLong("id"));
		type.setName(resultSet.getString("name"));
		return type;
	}

}
