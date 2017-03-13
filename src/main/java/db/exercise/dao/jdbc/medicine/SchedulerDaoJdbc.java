package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.SchedulerMapper;
import db.exercise.entities.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchedulerDaoJdbc {

	private static final String query = "SELECT D.firstName as d_firstName, D.lastName as d_lastName, D.middleName as d_middleName,\n" +
			"       P.firstName as p_firstName, P.lastName as p_lastName, P.middleName as p_middleName,\n" +
			"       scheduler.datetime as s_datetime\n" +
			"FROM scheduler\n" +
			"JOIN doctors as D on scheduler.doctorId = D.id\n" +
			"JOIN patients as P on scheduler.patientId = P.id";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Scheduler> findAll(){
		return jdbcTemplate.query(query, new SchedulerMapper());
	}

}
