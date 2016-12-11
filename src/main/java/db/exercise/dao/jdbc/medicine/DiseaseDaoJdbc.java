package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.DiseaseMapper;
import db.exercise.entities.medicine.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiseaseDaoJdbc {

	private static final String query = "SELECT * FROM diseases";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Disease> findAll(){
		return jdbcTemplate.query(query, new DiseaseMapper());
	}

}
