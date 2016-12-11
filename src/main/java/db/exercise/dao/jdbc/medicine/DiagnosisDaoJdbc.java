package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.DiagnosisMapper;
import db.exercise.entities.medicine.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiagnosisDaoJdbc {

	private static final String query = "SELECT * FROM diagnosises";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Diagnosis> findAll(){
		return jdbcTemplate.query(query, new DiagnosisMapper());
	}

}
