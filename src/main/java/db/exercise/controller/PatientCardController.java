package db.exercise.controller;

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
import java.util.stream.Collectors;

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

	//lab researches
	public TableView<Research> lab_table;
	public TableColumn<Research, Date> labDate;
	public TableColumn<Research, String> labName;
	public TableColumn<Research, String> labDoctor;

	//view researches
	public TableView<Research> viewTable;
	public TableColumn<Research, Date> viewDate;
	public TableColumn<Research, String> viewName;
	public TableColumn<Research, String> viewDoctor;

	//functional researches
	public TableView<Research> functionTable;
	public TableColumn<Research, Date> functionDate;
	public TableColumn<Research, String> functionName;
	public TableColumn<Research, String> functionDoctor;

	private Patient patient;
	private MainController mainController;

	@FXML
	private void initialize() {
		diagnosesTable.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
				handleDiagnosisDoubleClickButton();
			}
		});
		lab_table.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
				handleResearchLabDoubleClickButton();
			}
		});

		viewTable.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
				handleViewDoubleClickButton();
			}
		});

		functionTable.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
				handleFunctionalDoubleClickButton();
			}
		});

		diag_date.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDate()));
		doctor.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().toString()));
		specialization.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().getSpecialization()));
		diseases.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDisease()));

		labDate.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDate()));
		labName.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		labDoctor.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().toString()));

		viewDate.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDate()));
		viewName.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		viewDoctor.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().toString()));

		functionDate.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDate()));
		functionName.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		functionDoctor.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().toString()));

	}

	private void handleResearchLabDoubleClickButton() {
		Research selectedResearch = lab_table.getSelectionModel().getSelectedItem();
		mainController.getModalController().showResultDialog("Результат исследования", selectedResearch.getResult());
	}

	private void handleDiagnosisDoubleClickButton() {
		Diagnosis selectedDiagnosis = diagnosesTable.getSelectionModel().getSelectedItem();
		mainController.getModalController().showResultDialog("Заключение", selectedDiagnosis.getComment());
	}

	private void handleViewDoubleClickButton() {
		Research selectedResearch = viewTable.getSelectionModel().getSelectedItem();
		mainController.getModalController().showResultDialog("Результат осмотра", selectedResearch.getResult());
	}

	private void handleFunctionalDoubleClickButton() {
		Research selectedResearch = functionTable.getSelectionModel().getSelectedItem();
		mainController.getModalController().showResultDialog("Результат функционального исследования", selectedResearch.getResult());
	}

	public void setData(Patient patient, List<Diagnosis> diagnosisList, List<Research> researchList) {
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
		lab_table.setItems(FXCollections.observableArrayList(researchList.stream().filter(r -> r.getType() == 1).collect(Collectors.toList())));
		viewTable.setItems(FXCollections.observableArrayList(researchList.stream().filter(r -> r.getType() == 2).collect(Collectors.toList())));
		functionTable.setItems(FXCollections.observableArrayList(researchList.stream().filter(r -> r.getType() == 3).collect(Collectors.toList())));
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
}
