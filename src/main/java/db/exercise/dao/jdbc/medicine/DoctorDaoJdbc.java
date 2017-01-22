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

	private static final String query =
			"SELECT doctors.id, " +
					"firstName, " +
					"lastName, " +
					"middleName, " +
					"vacation, " +
					"Q.title as qualification, " +
					"S.title as specialization FROM doctors \n" +
			"join doctors_qualification as Q on Q.id = qualification \n" +
			"join doctors_specialization as S on S.id = specialization;";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Doctor> findAll(){
		return jdbcTemplate.query(query, new DoctorMapper());
	}

}
