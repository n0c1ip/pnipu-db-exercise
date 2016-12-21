package db.exercise.controller.boats;


import db.exercise.dao.jdbc.boats.TransportDaoJdbc;
import db.exercise.entities.boats.Transport;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransportController {

	private TransportDaoJdbc transportDaoJdbc;

	@FXML
	private TableView<Transport> tableView;
	@FXML
	public TableColumn<Transport, String> title;
	@FXML
	public TableColumn<Transport, String> number;
	@FXML
	public TableColumn<Transport, String> state;
	@FXML
	public TableColumn<Transport, String> type;
	@FXML
	public TableColumn<Transport, String> availability;

	@FXML
	private void initialize() {
		title.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		number.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNumber()));
		state.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getState()));
		type.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getType()));
		availability.setCellValueFactory(param -> new SimpleObjectProperty<>((param.getValue().isAvailability()) ? "Доступно" : "Не доступно"));
	}

	public void setTransportDaoJdbc(TransportDaoJdbc transportDaoJdbc) {
		this.transportDaoJdbc = transportDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(transportDaoJdbc.findAll()));
	}

}
