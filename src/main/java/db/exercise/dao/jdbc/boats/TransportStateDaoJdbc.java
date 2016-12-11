package db.exercise.dao.jdbc.boats;

import db.exercise.dao.mapper.boats.TransportStateMapper;
import db.exercise.entities.boats.TransportState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportStateDaoJdbc {

	private static final String query = "SELECT * FROM transport_states";

	@Autowired
	@Qualifier(value = "boatsTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<TransportState> findAll(){
		return jdbcTemplate.query(query, new TransportStateMapper());
	}

}