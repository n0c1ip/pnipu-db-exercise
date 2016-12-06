package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.VisitMapper;
import db.exercise.entities.medicine.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitDaoJdbc {

	private static final String query = "SELECT * FROM visits";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Visit> findAll(){
		return jdbcTemplate.query(query, new VisitMapper());
	}

}
