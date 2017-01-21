package db.exercise.controller.medicine;

import db.exercise.entities.medicine.Patient;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.Instant;
import java.time.ZoneId;

public class PatientCardController {

	@FXML
	public TextField lastName;
	@FXML
	public DatePicker birthDay;
	@FXML
	public TextField firstName;
	@FXML
	public TextField middleName;
	@FXML
	public TextArea address;


	private Patient patient;

	public void setPatient(Patient patient) {
		this.patient = patient;

		lastName.setText(patient.getLastName());
		firstName.setText(patient.getFirstName());
		middleName.setText(patient.getMiddleName());
		address.setText(patient.getAddress());
		birthDay.setValue(Instant.ofEpochMilli(patient.getBirthDay().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
	}
}
