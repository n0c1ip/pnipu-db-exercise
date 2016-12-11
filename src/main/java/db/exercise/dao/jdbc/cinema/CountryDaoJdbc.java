package db.exercise.dao.jdbc.cinema;

import db.exercise.dao.mapper.cinema.CountryMapper;
import db.exercise.entities.cinema.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDaoJdbc {

	private static final String query = "SELECT * FROM countries";

	@Autowired
	@Qualifier(value = "cinemaTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Country> findAll(){
		return jdbcTemplate.query(query, new CountryMapper());
	}


}