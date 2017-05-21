package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.DoctorMapper;
import db.exercise.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DoctorDaoJdbc {

	private static final String query = "SELECT * from v_doctors";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Doctor> findAll(){
		return jdbcTemplate.query(query, new DoctorMapper());
	}

}
