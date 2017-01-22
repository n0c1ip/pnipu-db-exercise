package db.exercise.controller.medicine;

import db.exercise.entities.Diagnosis;
import db.exercise.entities.Patient;
import db.exercise.entities.Research;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class PatientCardController {

	//patient card
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

	//diagnoses
	public TableView<Diagnosis> diagnosesTable;
	public TableColumn<Diagnosis, Date> diag_date;
	public TableColumn<Diagnosis, String> doctor;
	public TableColumn<Diagnosis, String> specialization;
	public TableColumn<Diagnosis, String> diseases;
	public TableColumn<Diagnosis, String> comment;

	//lab researches
	public TableView<Research> lab_table;
	public TableColumn<Research, Date> res_date;
	public TableColumn<Research, String> res_name;
	public TableColumn<Research, String> res_doctor;
	public TableColumn<Research, String> res_result;

	private Patient patient;

	@FXML
	private void initialize() {
		diagnosesTable.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
//				handlePatientDoubleClickButton();
			}
		});
		diag_date.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDate()));
		doctor.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().toString()));
		specialization.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().getSpecialization()));
		diseases.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDisease()));
		comment.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getComment()));
	}

	public void setData(Patient patient, List<Diagnosis> diagnosisList) {
		this.patient = patient;
		lastName.setText(patient.getLastName());
		firstName.setText(patient.getFirstName());
		middleName.setText(patient.getMiddleName());
		address.setText(patient.getAddress());
		birthDay.setValue(Instant.ofEpochMilli(patient.getBirthDay().getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
		if (patient.getMale() == 0) {
			female.setSelected(true);
			male.setDisable(true);
		} else {
			male.setSelected(true);
			female.setDisable(true);
		}
		cardNumber.setText(patient.getCardNumber());
		polis.setText(patient.getPolis());
		snils.setText(patient.getSnils());
		phone.setText(patient.getPhone());
		workInfo.setText(patient.getWorkInfo());

		diagnosesTable.setItems(FXCollections.observableArrayList(diagnosisList));
	}
}
