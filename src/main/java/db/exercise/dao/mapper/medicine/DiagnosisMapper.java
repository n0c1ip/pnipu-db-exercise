package db.exercise.dao.mapper.medicine;


import db.exercise.entities.Diagnosis;
import db.exercise.entities.Doctor;
import db.exercise.entities.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisMapper implements RowMapper<Diagnosis> {

	@Override
	public Diagnosis mapRow(ResultSet resultSet, int i) throws SQLException {
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setDate(resultSet.getDate("d_date"));
		diagnosis.setDisease(resultSet.getString("dis_title"));
		diagnosis.setDoctor(new Doctor(resultSet.getString("d_firstName"),
				resultSet.getString("d_lastName"),
				resultSet.getString("d_middleName"),
				resultSet.getString("ds_title")));
		diagnosis.setPatient(new Patient(resultSet.getString("p_firstName"),
				resultSet.getString("p_lastName"),
				resultSet.getString("p_middleName")));
		diagnosis.setComment(resultSet.getString("doc_comment"));
		return diagnosis;
	}
}
