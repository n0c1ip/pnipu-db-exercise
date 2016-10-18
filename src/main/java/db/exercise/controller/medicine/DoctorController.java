package db.exercise.controller.medicine;


import db.exercise.dao.jdbc.medicine.DoctorDaoJdbc;
import db.exercise.entities.medicine.Doctor;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Component;

@Component
public class DoctorController {

	private DoctorDaoJdbc doctorDaoJdbc;

	@FXML
	private TableView<Doctor> tableView;
	@FXML
	public TableColumn<Doctor, Long> idColumn;
	@FXML
	public TableColumn<Doctor, String> lastNameColumn;
	@FXML
	public TableColumn<Doctor, String> specColumn;
	@FXML
	public TableColumn<Doctor, String> qualificationColumn;

	@FXML
	private void initialize() {
		idColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		lastNameColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getLastName()));
		specColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getSpecialization()));
		qualificationColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getQualification()));
	}

	public void setDoctorDaoJdbc(DoctorDaoJdbc doctorDaoJdbc) {
		this.doctorDaoJdbc = doctorDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(doctorDaoJdbc.findAll()));
	}
}
