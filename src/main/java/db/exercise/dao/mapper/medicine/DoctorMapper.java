package db.exercise.dao.mapper.medicine;

import db.exercise.entities.medicine.Doctor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorMapper implements RowMapper<Doctor> {

	@Override
	public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {
		Doctor doctor = new Doctor();
		doctor.setId(resultSet.getLong("id"));
		doctor.setLastName(resultSet.getString("lastName"));
		doctor.setQualification(resultSet.getString("qualification"));
		doctor.setSpecialization(resultSet.getString("specialization"));
		return doctor;
	}
}
