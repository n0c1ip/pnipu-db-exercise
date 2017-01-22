package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.ResearchMapper;
import db.exercise.entities.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResearchDaoJdbc {

	private static final String query =
			"SELECT D.firstName as d_firstName, D.lastName as d_lastName, D.middleName as d_middleName,\n" +
					"       P.firstName as p_firstName, P.lastName as p_lastName, P.middleName as p_middleName,\n" +
					"       res_date, R.title as r_title, type as r_type, result from patients_research\n" +
					"JOIN doctors as D on patients_research.doctor = D.id\n" +
					"JOIN patients as P on patients_research.patient = P.id\n" +
					"JOIN research as R on patients_research.research_ref = R.id where patients_research.id = ?";

	private static final String queryAll =
			"SELECT D.firstName as d_firstName, D.lastName as d_lastName, D.middleName as d_middleName,\n" +
					"       P.firstName as p_firstName, P.lastName as p_lastName, P.middleName as p_middleName,\n" +
					"       res_date, R.title as r_title, type as r_type, result from patients_research\n" +
					"JOIN doctors as D on patients_research.doctor = D.id\n" +
					"JOIN patients as P on patients_research.patient = P.id\n" +
					"JOIN research as R on patients_research.research_ref = R.id";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Research> findAll(){
		return jdbcTemplate.query(queryAll, new ResearchMapper());
	}

	public List<Research> findById(Long id){
		return jdbcTemplate.query(query, new ResearchMapper(), new Object[]{id});
	}


}
