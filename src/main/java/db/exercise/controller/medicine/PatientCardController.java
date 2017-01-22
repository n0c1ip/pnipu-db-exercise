package db.exercise.controller.medicine;

import db.exercise.entities.Patient;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.Instant;
import java.time.ZoneId;

public class PatientCardController {

	public TextField lastName;
	public DatePicker birthDay;
	public TextField firstName;
	public TextField middleName;
	public TextArea address;
	public CheckBox female;
	public CheckBox male;
	public TextField cardNumber;
	public TextField polis;
	public TextField snils;
	public TextField phone;
	public TextArea workInfo;

	private Patient patient;

	public void setPatient(Patient patient) {
		this.patient = patient;

		lastName.setText(patient.getLastName());
		firstName.setText(patient.getFirstName());
		middleName.setText(patient.getMiddleName());
		address.setText(patient.getAddress());
		birthDay.setValue(Instant.ofEpochMilli(patient.getBirthDay().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		if (patient.getMale() == 0) {
			female.setSelected(true);
		} else {
			male.setSelected(true);
		}
		cardNumber.setText(patient.getCardNumber());
		polis.setText(patient.getPolis());
		snils.setText(patient.getSnils());
		phone.setText(patient.getPhone());
		workInfo.setText(patient.getWorkInfo());
	}
}
