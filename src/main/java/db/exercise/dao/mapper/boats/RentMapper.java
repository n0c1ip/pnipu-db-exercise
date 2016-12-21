package db.exercise.dao.mapper.boats;

import db.exercise.entities.boats.Rent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentMapper implements RowMapper<Rent> {

	@Override
	public Rent mapRow(ResultSet resultSet, int i) throws SQLException {
		Rent rent = new Rent();
		rent.setTitle(resultSet.getString("title"));
		rent.setClient(resultSet.getString("client"));
		rent.setType(resultSet.getString("type"));
		rent.setWater(resultSet.getString("water"));
		rent.setRented_at(resultSet.getTimestamp("rented_at"));
		rent.setRented_to(resultSet.getTimestamp("rented_to"));
		return rent;
	}

}