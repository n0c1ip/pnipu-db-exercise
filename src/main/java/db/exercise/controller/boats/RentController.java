package db.exercise.controller.boats;

import db.exercise.dao.jdbc.boats.RentDaoJdbc;
import db.exercise.entities.boats.Rent;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

public class RentController {

	private RentDaoJdbc rentDaoJdbc;

	@FXML
	private TableView<Rent> tableView;
	@FXML
	public TableColumn<Rent, String> title;
	@FXML
	public TableColumn<Rent, String> client;
	@FXML
	public TableColumn<Rent, String> type;
	@FXML
	public TableColumn<Rent, String> water;
	@FXML
	public TableColumn<Rent, Date> rented_at;
	@FXML
	public TableColumn<Rent, Date> rented_to;

	@FXML
	private void initialize() {
		title.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		client.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getClient()));
		type.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getType()));
		water.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getWater()));
		rented_at.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getRented_at()));
		rented_to.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getRented_to()));
	}

	public void setRentDaoJdbc(RentDaoJdbc rentDaoJdbc) {
		this.rentDaoJdbc = rentDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(rentDaoJdbc.findAll()));
	}

}
