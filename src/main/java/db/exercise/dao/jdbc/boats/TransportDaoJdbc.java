package db.exercise.dao.jdbc.boats;

import db.exercise.dao.mapper.boats.TransportMapper;
import db.exercise.entities.boats.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportDaoJdbc {

	private static final String query = "SELECT * FROM transports";

	@Autowired
	@Qualifier(value = "boatsTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Transport> findAll(){
		return jdbcTemplate.query(query, new TransportMapper());
	}


}