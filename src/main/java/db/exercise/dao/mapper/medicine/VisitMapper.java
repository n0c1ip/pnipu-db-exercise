package db.exercise.dao.mapper.medicine;

import db.exercise.entities.medicine.Visit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitMapper implements RowMapper<Visit> {
	@Override
	public Visit mapRow(ResultSet resultSet, int i) throws SQLException {
		Visit visit = new Visit();
		visit.setId(resultSet.getLong("id"));
		visit.setDoctorId(resultSet.getLong("doctorId"));
		visit.setPatientId(resultSet.getLong("patientId"));
		visit.setVisitDate(resultSet.getDate("visitDate"));
		return visit;
	}
}
