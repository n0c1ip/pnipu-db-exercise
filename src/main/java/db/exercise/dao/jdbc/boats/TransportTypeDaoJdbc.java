package db.exercise.dao.jdbc.boats;

import db.exercise.dao.mapper.boats.TransportTypeMapper;
import db.exercise.entities.boats.TransportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportTypeDaoJdbc {

	private static final String query = "SELECT * FROM transport_types";

	@Autowired
	@Qualifier(value = "boatsTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<TransportType> findAll(){
		return jdbcTemplate.query(query, new TransportTypeMapper());
	}


}