package db.exercise.dao.mapper.medicine;

import db.exercise.entities.medicine.Disease;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiseaseMapper implements RowMapper<Disease> {

	@Override
	public Disease mapRow(ResultSet resultSet, int i) throws SQLException {
		Disease disease = new Disease();
		disease.setId(resultSet.getLong("id"));
		disease.setTitle(resultSet.getString("title"));
		return disease;
	}
}
