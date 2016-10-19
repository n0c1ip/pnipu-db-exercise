package db.exercise.controller.medicine;

import db.exercise.dao.jdbc.medicine.PatientDaoJdbc;
import db.exercise.entities.medicine.Patient;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

public class PatientController {

	private PatientDaoJdbc patientDaoJdbc;

	@FXML
	private TableView<Patient> tableView;
	@FXML
	public TableColumn<Patient, Long> id;
	@FXML
	public TableColumn<Patient, String> lastName;
	@FXML
	public TableColumn<Patient, Date> birthDay;
	@FXML
	public TableColumn<Patient, String> address;

	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		lastName.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getLastName()));
		birthDay.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getBirthDay()));
		address.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAddress()));
	}

	public void setDoctorDaoJdbc(PatientDaoJdbc patientDaoJdbc) {
		this.patientDaoJdbc = patientDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(patientDaoJdbc.findAll()));
	}
}
