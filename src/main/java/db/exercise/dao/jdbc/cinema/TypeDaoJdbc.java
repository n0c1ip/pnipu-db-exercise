package db.exercise.dao.jdbc.cinema;

import db.exercise.dao.mapper.cinema.TypeMapper;
import db.exercise.entities.cinema.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeDaoJdbc {

	private static final String query = "SELECT * FROM cinema_types";

	@Autowired
	@Qualifier(value = "cinemaTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Type> findAll(){
		return jdbcTemplate.query(query, new TypeMapper());
	}


}