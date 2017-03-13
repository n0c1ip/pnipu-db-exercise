package db.exercise.dao.mapper.medicine;

import db.exercise.entities.Doctor;
import db.exercise.entities.Patient;
import db.exercise.entities.Scheduler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchedulerMapper implements RowMapper<Scheduler> {

	@Override
	public Scheduler mapRow(ResultSet resultSet, int i) throws SQLException {
		Scheduler scheduler = new Scheduler();
		scheduler.setDate(resultSet.getTimestamp("s_datetime"));
		scheduler.setPatient(new Patient(resultSet.getString("p_firstName"),
				resultSet.getString("p_lastName"),
				resultSet.getString("p_middleName")));
		scheduler.setDoctor(new Doctor(resultSet.getString("d_firstName"),
				resultSet.getString("d_lastName"),
				resultSet.getString("d_middleName"),""));
		return scheduler;
	}

}
