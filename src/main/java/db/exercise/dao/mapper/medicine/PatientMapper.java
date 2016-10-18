package db.exercise.dao.mapper.medicine;

import db.exercise.entities.medicine.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMapper implements RowMapper<Patient> {

	@Override
	public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
		Patient patient = new Patient();
		patient.setId(resultSet.getLong("id"));
		patient.setAddress(resultSet.getString("address"));
		patient.setBirthDay(resultSet.getDate("birthday"));
		patient.setLastName(resultSet.getString("lastName"));
		return patient;
	}
}
