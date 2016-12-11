package db.exercise.dao.mapper.cinema;

import db.exercise.entities.cinema.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {

	@Override
	public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
		Movie movie = new Movie();
		movie.setId(resultSet.getLong("id"));
		movie.setTitle(resultSet.getString("title"));
		movie.setDirector(resultSet.getLong("director"));
		movie.setCreatedDate(resultSet.getDate("createdDate"));
		movie.setCountry(resultSet.getLong("country"));
		movie.setSeriesCount(resultSet.getInt("seriesCount"));
		movie.setTheme(resultSet.getInt("theme"));
		return movie;
	}

}