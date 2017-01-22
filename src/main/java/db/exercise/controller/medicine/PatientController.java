package db.exercise.controller.medicine;

import db.exercise.controller.MainController;
import db.exercise.controller.ModalController;
import db.exercise.dao.jdbc.medicine.PatientDaoJdbc;
import db.exercise.entities.Patient;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

public class PatientController {

	private PatientDaoJdbc patientDaoJdbc;
	private MainController mainController;
	private ModalController modalController;

	@FXML
	private TableView<Patient> tableView;
	public TableColumn<Patient, String> name;
	public TableColumn<Patient, Date> birthDay;
	public TableColumn<Patient, String> address;
	public TableColumn <Patient, String> control;


	@FXML
	private void initialize() {
		tableView.setOnMousePressed(event -> {
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

	public void setDoctorDaoJdbc(PatientDaoJdbc patientDaoJdbc) {
		this.patientDaoJdbc = patientDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(patientDaoJdbc.findAll()));
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}


	@FXML
	private void handlePatientDoubleClickButton() {
		Patient selectedPatient = tableView.getSelectionModel().getSelectedItem();
		if (selectedPatient != null) {
			mainController.getModalController().showPatientEditDialog("Карточка пациента - " + selectedPatient.toString(), selectedPatient);
		}
	}

}
