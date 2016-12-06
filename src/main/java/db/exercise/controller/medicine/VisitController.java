package db.exercise.controller.medicine;

import db.exercise.dao.jdbc.medicine.VisitDaoJdbc;
import db.exercise.entities.medicine.Visit;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

/**
 * Created by makhnutin on 19.10.2016.
 */
public class VisitController {

	private VisitDaoJdbc visitDaoJdbc;

	@FXML
	private TableView<Visit> tableView;

	@FXML
	public TableColumn<Visit,Long> idColumn;
	@FXML
	public TableColumn<Visit,Long> patientIdColumn;
	@FXML
	public TableColumn<Visit,Long> doctorIdColumn;
	@FXML
	public TableColumn<Visit,Date> visitDateColumn;

	@FXML
	private void initialize() {
		idColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		patientIdColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPatientId()));
		doctorIdColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctorId()));
		visitDateColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVisitDate()));
	}

	public void setVisitDaoJdbc(VisitDaoJdbc visitDaoJdbc) {
		this.visitDaoJdbc = visitDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(visitDaoJdbc.findAll()));
	}


}
