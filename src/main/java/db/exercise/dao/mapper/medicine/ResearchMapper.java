package db.exercise.dao.mapper.medicine;

import db.exercise.entities.Doctor;
import db.exercise.entities.Patient;
import db.exercise.entities.Research;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResearchMapper implements RowMapper<Research> {

	@Override
	public Research mapRow(ResultSet resultSet, int i) throws SQLException {
		Research research = new Research();
		research.setDate(resultSet.getDate("res_date"));
		research.setPatient(new Patient(resultSet.getString("p_firstName"),
				resultSet.getString("p_lastName"),
				resultSet.getString("p_middleName")));
		research.setDoctor(new Doctor(resultSet.getString("d_firstName"),
				resultSet.getString("d_lastName"),
				resultSet.getString("d_middleName"),""));
		research.setTitle(resultSet.getString("r_title"));
		research.setType(resultSet.getInt("r_type"));
		research.setResult(resultSet.getString("result"));
		return research;
	}
}
