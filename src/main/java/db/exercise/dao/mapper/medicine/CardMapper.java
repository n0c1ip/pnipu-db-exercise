package db.exercise.dao.mapper.medicine;


import db.exercise.entities.medicine.Card;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper implements RowMapper<Card> {

	@Override
	public Card mapRow(ResultSet resultSet, int i) throws SQLException {
		Card card = new Card();
		card.setDiseaseTitle(resultSet.getString("title"));
		card.setDoctorName(resultSet.getString("dLastName"));
		card.setPatientName(resultSet.getString("pLastName"));
		card.setVisitDate(resultSet.getDate("visitDate"));
		return card;
	}

}
