package db.exercise.dao.jdbc.cinema;

import db.exercise.dao.mapper.cinema.ShowMapper;
import db.exercise.entities.cinema.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ShowDaoJdbc {

	private static final String query = "SELECT * FROM shows";

	@Autowired
	@Qualifier(value = "cinemaTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Show> findAll(){
		return jdbcTemplate.query(query, new ShowMapper());
	}

}