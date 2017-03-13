package db.exercise.controller;

import db.exercise.dao.jdbc.medicine.SchedulerDaoJdbc;
import db.exercise.entities.Scheduler;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.SimpleDateFormat;

public class SchedulerController {

	@FXML
	public TableView<Scheduler> tableView;
	public TableColumn<Scheduler, String> doctor;
	public TableColumn<Scheduler, String> patient;
	public TableColumn<Scheduler, String> datetime;

	private SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

	@FXML
	private void initialize() {

		doctor.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctor().toString()));
		patient.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPatient().toString()));
		datetime.setCellValueFactory(param -> new SimpleObjectProperty<>(sf.format(param.getValue().getDate())));
	}



	public void setSchedulerDaoJdbc(SchedulerDaoJdbc schedulerDaoJdbc) {
		tableView.setItems(FXCollections.observableArrayList(schedulerDaoJdbc.findAll()));
	}


}
