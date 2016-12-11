package db.exercise.dao.mapper.cinema;

import db.exercise.entities.cinema.Director;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorMapper implements RowMapper<Director> {

	@Override
	public Director mapRow(ResultSet resultSet, int i) throws SQLException {
		Director director = new Director();
		director.setId(resultSet.getLong("id"));
		director.setLastName(resultSet.getString("name"));
		return director;
	}

}
