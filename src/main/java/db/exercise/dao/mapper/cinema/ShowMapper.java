package db.exercise.dao.mapper.cinema;

import db.exercise.entities.cinema.Show;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowMapper implements RowMapper<Show> {

	@Override
	public Show mapRow(ResultSet resultSet, int i) throws SQLException {
		Show show = new Show();
		show.setId(resultSet.getLong("id"));
		show.setCinema(resultSet.getLong("cinema"));
		show.setMovie(resultSet.getLong("movie"));
		show.setDate(resultSet.getTimestamp("date"));
		return show;
	}

}
