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
			"SELECT \n" +
					"  D.firstName as d_firstName,\n" +
					"  D.lastName as d_lastName,\n" +
					"  D.middleName as d_middleName, \n" +
					"  D_S.title as ds_title,\n" +
					"  P.firstName as p_firstName, \n" +
					"  P.lastName as p_lastName, \n" +
					"  P.middleName as p_middleName,\n" +
					"  DIS.title as dis_title, \n" +
					"  d_date, \n" +
					"  doc_comment \n" +
					"FROM diagnosises DG \n" +
					"  JOIN doctors D on DG.doctor = D.id\n" +
					"  JOIN patients P on DG.patient = P.id\n" +
					"  JOIN diseases DIS on DG.disease = DIS.id\n" +
					"  JOIN doctors_specialization D_S on D.specialization = D_S.id \n" +
					"WHERE P.id = ?";

	private static final String queryAll =
			"SELECT \n" +
					"  D.firstName as d_firstName,\n" +
					"  D.lastName as d_lastName,\n" +
					"  D.middleName as d_middleName, \n" +
					"  D_S.title as ds_title,\n" +
					"  P.firstName as p_firstName, \n" +
					"  P.lastName as p_lastName, \n" +
					"  P.middleName as p_middleName,\n" +
					"  DIS.title as dis_title, \n" +
					"  d_date, \n" +
					"  doc_comment \n" +
					"FROM diagnosises DG \n" +
					"  JOIN doctors D on DG.doctor = D.id\n" +
					"  JOIN patients P on DG.patient = P.id\n" +
					"  JOIN diseases DIS on DG.disease = DIS.id\n" +
					"  JOIN doctors_specialization D_S on D.specialization = D_S.id";

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
