package db.exercise.controller;

import db.exercise.dao.jdbc.medicine.DiagnosisDaoJdbc;
import db.exercise.dao.jdbc.medicine.PatientDaoJdbc;
import db.exercise.dao.jdbc.medicine.ResearchDaoJdbc;
import db.exercise.entities.Diagnosis;
import db.exercise.entities.Patient;
import db.exercise.entities.Research;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientController {

	private PatientDaoJdbc patientDaoJdbc;
	private DiagnosisDaoJdbc diagnosisDaoJdbc;
	private ResearchDaoJdbc researchDaoJdbc;

	private MainController mainController;

	@FXML
	private TableView<Patient> tableView;
	public TableColumn<Patient, String> name;
	public TableColumn<Patient, Date> birthDay;
	public TableColumn<Patient, String> address;
	public TableColumn <Patient, String> control;

	ContextMenu patientsContextMenu;

	@FXML
	private void initialize() {
		initiatePatientContextMenu();
		tableView.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown() && patientsContextMenu.isShowing()){
				patientsContextMenu.hide();
			}
			if (event.isSecondaryButtonDown()) {
				patientsContextMenu.show(tableView,event.getScreenX(),event.getScreenY());
			}
			if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
				handlePatientDoubleClickButton();
			}
		});

		name.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().toString()));
		birthDay.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getBirthDay()));
		address.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAddress()));
		control.setCellValueFactory(param -> {
			if(param.getValue().isOnControl()) {
				return new SimpleObjectProperty<>("ДА");
			} else {
				return new SimpleObjectProperty<>("НЕТ");
			}
		});
	}

	private void initiatePatientContextMenu(){
		MenuItem addPatient = new MenuItem("Добавить пациента");
		MenuItem editPatient = new MenuItem("Редактировать пациента");
		MenuItem removePatient = new MenuItem("Удалить пациента");

		patientsContextMenu = new ContextMenu(addPatient,editPatient,removePatient);

		addPatient.setOnAction(event -> handleNewPatientButton());
		editPatient.setOnAction(event -> handlePatientDoubleClickButton());
		removePatient.setOnAction(event -> handleDeletePatient());
	}

	private void handleDeletePatient() {

	}

	private void handleNewPatientButton() {
		Patient newPatient = new Patient();
		newPatient.setBirthDay(new Date());
		newPatient.setMale(new Short("0"));
		mainController.getModalController().showPatientEditDialog("Добавление нового пациента", newPatient, new ArrayList<>(), new ArrayList<>());
	}

	public void setDaoJdbc(PatientDaoJdbc patientDaoJdbc, DiagnosisDaoJdbc diagnosisDaoJdbc, ResearchDaoJdbc researchDaoJdbc) {
		this.patientDaoJdbc = patientDaoJdbc;
		this.diagnosisDaoJdbc = diagnosisDaoJdbc;
		this.researchDaoJdbc = researchDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(patientDaoJdbc.findAll()));
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	@FXML
	private void handlePatientDoubleClickButton() {
		Patient selectedPatient = tableView.getSelectionModel().getSelectedItem();
		if (selectedPatient != null) {
			List<Diagnosis> diagnosisList = diagnosisDaoJdbc.findByPatientId(selectedPatient.getId());
			List<Research> researchList = researchDaoJdbc.findByPatientId(selectedPatient.getId());
			mainController.getModalController().showPatientEditDialog("Карточка пациента - " +
					selectedPatient.toString(), selectedPatient, diagnosisList, researchList);
		}
	}

}
