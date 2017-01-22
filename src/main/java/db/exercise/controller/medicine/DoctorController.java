package db.exercise.controller.medicine;

import db.exercise.controller.MainController;
import db.exercise.controller.ModalController;
import db.exercise.dao.jdbc.medicine.DoctorDaoJdbc;
import db.exercise.entities.Doctor;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DoctorController {

	public TableView<Doctor> tableView;
	public TableColumn<Doctor, String> name;
	public TableColumn<Doctor, String> specialization;
	public TableColumn<Doctor, String> qualification;
	public TableColumn<Doctor, String> vacation;

	private DoctorDaoJdbc doctorDaoJdbc;
	private MainController mainController;
	private ModalController modalController;

	@FXML
	private void initialize() {
		tableView.setOnMousePressed(event -> {
			if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
				handlePatientDoubleClickButton();
			}
		});
		name.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().toString()));
		specialization.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getSpecialization()));
		qualification.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getQualification()));
		vacation.setCellValueFactory(param -> {
			if(param.getValue().isVacation()) {
				return new SimpleObjectProperty<>("НЕТ");
			} else {
				return new SimpleObjectProperty<>("ДА");
			}
		});
	}

	public void setDoctorDaoJdbc(DoctorDaoJdbc doctorDaoJdbc) {
		this.doctorDaoJdbc = doctorDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(doctorDaoJdbc.findAll()));
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}


	@FXML
	private void handlePatientDoubleClickButton() {
		Doctor selectedDoctor = tableView.getSelectionModel().getSelectedItem();
		if (selectedDoctor != null) {
//			mainController.getModalController().showPatientEditDialog("Карточка пациента - " + selectedPatient.toString(), selectedPatient);
		}
	}



}
