package db.exercise.dao.jdbc.medicine;

import db.exercise.dao.mapper.medicine.DiagnosisMapper;
import db.exercise.entities.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiagnosisDaoJdbc {

	private static final String query =
			"SELECT d.firstName as d_firstName, D.lastName as d_lastName, D.middleName as d_middleName, D_S.title as ds_title,\n" +
					"       P.firstName as p_firstName, P.lastName as p_lastName, P.middleName as p_middleName,\n" +
					"       DIS.title as dis_title, date, doc_comment from diagnoses\n" +
					"JOIN doctors as D on diagnoses.doctor = D.id\n" +
					"JOIN patients as P on diagnoses.patient = P.id\n" +
					"JOIN diseases as DIS on diagnoses.disease = DIS.id\n" +
					"JOIN doctors_specialization as D_S on D.specialization = D_S.id WHERE P.id = ?";

	private static final String queryAll =
			"SELECT D.firstName as d_firstName, D.lastName as d_lastName, D.middleName as d_middleName, D_S.title as ds_title,\n" +
					"       P.firstName as p_firstName, P.lastName as p_lastName, P.middleName as p_middleName,\n" +
					"       DIS.title as dis_title, date, doc_comment from diagnoses\n" +
					"JOIN doctors as D on diagnoses.doctor = D.id\n" +
					"JOIN patients as P on diagnoses.patient = P.id\n" +
					"JOIN diseases as DIS on diagnoses.disease = DIS.id\n" +
					"JOIN doctors_specialization as D_S on D.specialization = D_S.id";

	@Autowired
	@Qualifier(value = "medicineTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Diagnosis> findAll(){
		return jdbcTemplate.query(queryAll, new DiagnosisMapper());
	}

	public List<Diagnosis> findByPatientId(Long id){
		return jdbcTemplate.query(query, new DiagnosisMapper(), new Object[]{id});
	}



}
