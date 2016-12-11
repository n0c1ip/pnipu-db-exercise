package db.exercise.dao.jdbc.cinema;

import db.exercise.dao.mapper.cinema.DirectorMapper;
import db.exercise.entities.cinema.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorDaoJdbc {

	private static final String query = "SELECT * FROM directors";

	@Autowired
	@Qualifier(value = "cinemaTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Director> findAll(){
		return jdbcTemplate.query(query, new DirectorMapper());
	}


}