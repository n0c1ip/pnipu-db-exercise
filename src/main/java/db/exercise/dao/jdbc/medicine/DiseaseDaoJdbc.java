package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.DiseaseMapper;
import db.exercise.entities.medicine.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DiseaseDaoJdbc {

	private static final String query = "SELECT * FROM diseases";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Disease> findAll(){
		return jdbcTemplate.query(query, new DiseaseMapper());
	}

}
