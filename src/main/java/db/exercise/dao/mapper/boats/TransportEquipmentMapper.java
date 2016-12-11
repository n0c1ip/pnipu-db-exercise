package db.exercise.dao.mapper.boats;

import db.exercise.entities.boats.TransportEquipment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportEquipmentMapper implements RowMapper<TransportEquipment> {

	@Override
	public TransportEquipment mapRow(ResultSet resultSet, int i) throws SQLException {
		TransportEquipment equipment = new TransportEquipment();
		equipment.setId(resultSet.getLong("id"));
		equipment.setTitle(resultSet.getString("title"));
		return equipment;
	}

}