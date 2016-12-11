package db.exercise.dao.mapper.cinema;

import db.exercise.entities.cinema.Theme;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThemeMapper implements RowMapper<Theme> {

	@Override
	public Theme mapRow(ResultSet resultSet, int i) throws SQLException {
		Theme theme = new Theme();
		theme.setId(resultSet.getLong("id"));
		theme.setName(resultSet.getString("title"));
		return theme;
	}

}
