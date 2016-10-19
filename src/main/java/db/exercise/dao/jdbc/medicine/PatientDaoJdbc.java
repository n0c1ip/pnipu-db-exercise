package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.PatientMapper;
import db.exercise.entities.medicine.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoJdbc {

	private static final String query = "SELECT * FROM patients";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Patient> findAll(){
		return jdbcTemplate.query(query, new PatientMapper());
	}

}
