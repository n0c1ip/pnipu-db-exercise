package db.exercise.controller.medicine;

import db.exercise.dao.jdbc.medicine.DiagnosisDaoJdbc;
import db.exercise.entities.medicine.Diagnosis;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DiagnosisController {

	private DiagnosisDaoJdbc diagnosisDaoJdbc;

	@FXML
	private TableView<Diagnosis> tableView;
	@FXML
	public TableColumn<Diagnosis, Long> id;
	@FXML
	public TableColumn<Diagnosis, Long> patientColumn;
	@FXML
	public TableColumn<Diagnosis, Long> doctorColumn;
	@FXML
	public TableColumn<Diagnosis, Long> diseaseColumn;
	@FXML
	public TableColumn<Diagnosis, Long> visitColumn;

	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		patientColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPatientId()));
		doctorColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctorId()));
		diseaseColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDiseaseId()));
		visitColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVisitId()));
	}

	public void setDiagnosisDaoJdbc(DiagnosisDaoJdbc diagnosisDaoJdbc) {
		this.diagnosisDaoJdbc = diagnosisDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(diagnosisDaoJdbc.findAll()));
	}

}
