package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.ResearchMapper;
import db.exercise.entities.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResearchDaoJdbc {

	private static final String query =
			"SELECT * from v_researches where patient_id = ?";

	private static final String queryAll =
			"SELECT * from v_researches";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Research> findAll(){
		return jdbcTemplate.query(queryAll, new ResearchMapper());
	}

	public List<Research> findByPatientId(Long id){
		return jdbcTemplate.query(query, new ResearchMapper(), new Object[]{id});
	}

}
