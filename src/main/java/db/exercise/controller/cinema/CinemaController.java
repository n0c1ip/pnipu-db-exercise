package db.exercise.controller.cinema;

import db.exercise.dao.jdbc.cinema.CinemaDaoJdbc;
import db.exercise.entities.cinema.Cinema;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CinemaController {

	private CinemaDaoJdbc cinemaDaoJdbc;

	@FXML
	private TableView<Cinema> tableView;
	@FXML
	public TableColumn<Cinema, Long> id;
	@FXML
	public TableColumn<Cinema, String> title;
	@FXML
	public TableColumn<Cinema, String> address;
	@FXML
	public TableColumn<Cinema, String> phone;
	@FXML
	public TableColumn<Cinema, Long> type;
	@FXML
	public TableColumn<Cinema, Integer> capacity;
	@FXML
	public TableColumn<Cinema, Integer> hallCount;

	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		title.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		address.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getAddress()));
		phone.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPhone()));
		type.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getType()));
		capacity.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCapacity()));
		hallCount.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getHallCount()));
	}

	public void setCinemaDaoJdbc(CinemaDaoJdbc cinemaDaoJdbc) {
		this.cinemaDaoJdbc = cinemaDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(cinemaDaoJdbc.findAll()));
	}

}
