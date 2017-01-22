package db.exercise.dao.mapper.medicine;

import db.exercise.entities.Patient;
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
		patient.setFirstName(resultSet.getString("firstName"));
		patient.setMiddleName(resultSet.getString("middleName"));
		patient.setOnControl(resultSet.getBoolean("control"));
		patient.setCardNumber(resultSet.getString("card_number"));
		patient.setSnils(resultSet.getString("snils"));
		patient.setPolis(resultSet.getString("polis"));
		patient.setPhone(resultSet.getString("phone"));
		patient.setMale(resultSet.getShort("male"));
		patient.setWorkInfo(resultSet.getString("workinfo"));
		return patient;
	}
}
