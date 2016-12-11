package db.exercise.dao.jdbc.cinema;

import db.exercise.dao.mapper.cinema.MovieMapper;
import db.exercise.entities.cinema.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoJdbc {

	private static final String query = "SELECT * FROM movies";

	@Autowired
	@Qualifier(value = "cinemaTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Movie> findAll(){
		return jdbcTemplate.query(query, new MovieMapper());
	}


}