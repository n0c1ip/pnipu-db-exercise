package db.exercise.dao.mapper.cinema;

import db.exercise.entities.cinema.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet resultSet, int i) throws SQLException {
		Country country = new Country();
		country.setId(resultSet.getLong("id"));
		country.setName(resultSet.getString("title"));
		return country;
	}

}