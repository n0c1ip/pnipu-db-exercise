package db.exercise.dao.jdbc.boats;

import db.exercise.dao.mapper.boats.TransportEquipmentMapper;
import db.exercise.entities.boats.TransportEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TransportEquipmentDaoJdbc {

	private static final String query = "SELECT * FROM transport_equipment";

	@Autowired
	@Qualifier(value = "boatsTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<TransportEquipment> findAll(){
		return jdbcTemplate.query(query, new TransportEquipmentMapper());
	}

}
