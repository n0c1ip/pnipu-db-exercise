package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.CardMapper;
import db.exercise.entities.medicine.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDaoJdbc {

	private static final String query = "SELECT P.lastName as pLastName, DOC.lastName as dLastName, DS.title, V.visitDate FROM diagnosises as DG \n" +
			"join diseases as DS on DG.diseaseId = DS.id \n" +
			"join visits as V on DG.visitId = V.id\n" +
			"join doctors as DOC on V.doctorId = DOC.id\n" +
			"join patients as P on V.patientId = P.id";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Card> findAll(){
		return jdbcTemplate.query(query, new CardMapper());
	}

}
