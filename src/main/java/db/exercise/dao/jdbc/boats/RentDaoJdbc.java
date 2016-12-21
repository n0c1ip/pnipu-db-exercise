package db.exercise.dao.jdbc.boats;

import db.exercise.dao.mapper.boats.RentMapper;
import db.exercise.entities.boats.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentDaoJdbc {

	private static final String query = "SELECT * FROM v_rent";

	@Autowired
	@Qualifier(value = "boatsTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Rent> findAll(){
		return jdbcTemplate.query(query, new RentMapper());
	}


}