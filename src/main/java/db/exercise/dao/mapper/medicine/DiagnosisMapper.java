package db.exercise.dao.mapper.medicine;

import db.exercise.entities.medicine.Diagnosis;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosisMapper implements RowMapper<Diagnosis> {

	@Override
	public Diagnosis mapRow(ResultSet resultSet, int i) throws SQLException {
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setId(resultSet.getLong("id"));
		diagnosis.setPatientId(resultSet.getLong("patientId"));
		diagnosis.setDoctorId(resultSet.getLong("doctorId"));
		diagnosis.setDiseaseId(resultSet.getLong("diseaseId"));
		diagnosis.setVisitId(resultSet.getLong("visitId"));
		return diagnosis;
	}
}
