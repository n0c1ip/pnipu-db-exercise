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

	private static final String query = "SELECT * from v_visits";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Scheduler> findAll(){
		return jdbcTemplate.query(query, new SchedulerMapper());
	}

}
