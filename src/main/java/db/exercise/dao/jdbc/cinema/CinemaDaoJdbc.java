package db.exercise.dao.jdbc.cinema;

import db.exercise.dao.mapper.cinema.CinemaMapper;
import db.exercise.entities.cinema.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaDaoJdbc {

	private static final String query = "SELECT * FROM cinemas";

	@Autowired
	@Qualifier(value = "cinemaTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Cinema> findAll(){
		return jdbcTemplate.query(query, new CinemaMapper());
	}


}
