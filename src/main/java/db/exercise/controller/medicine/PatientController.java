package db.exercise.controller.medicine;

import db.exercise.controller.MainController;
import db.exercise.dao.jdbc.medicine.DoctorDaoJdbc;

public class PatientController {

	private MainController mainController;
	private DoctorDaoJdbc doctorDaoJdbc;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void setDoctorDaoJdbc(DoctorDaoJdbc doctorDaoJdbc) {
		this.doctorDaoJdbc = doctorDaoJdbc;
	}
}
