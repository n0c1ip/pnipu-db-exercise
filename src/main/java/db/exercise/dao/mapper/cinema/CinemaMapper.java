package db.exercise.dao.mapper.cinema;

import db.exercise.entities.cinema.Cinema;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CinemaMapper implements RowMapper<Cinema> {

	@Override
	public Cinema mapRow(ResultSet resultSet, int i) throws SQLException {
		Cinema country = new Cinema();
		country.setId(resultSet.getLong("id"));
		country.setTitle(resultSet.getString("title"));
		country.setAddress(resultSet.getString("address"));
		country.setPhone(resultSet.getString("phone"));
		country.setType(resultSet.getLong("type"));
		country.setCapacity(resultSet.getInt("capacity"));
		country.setHallCount(resultSet.getInt("hallCount"));
		return country;
	}

}