package db.exercise.controller.cinema;

import db.exercise.dao.jdbc.cinema.ShowDaoJdbc;
import db.exercise.entities.cinema.Show;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.SimpleDateFormat;

public class ShowsController {

	private ShowDaoJdbc showDaoJdbc;

	@FXML
	private TableView<Show> tableView;
	@FXML
	public TableColumn<Show, Long> id;
	@FXML
	public TableColumn<Show, Long> cinema;
	@FXML
	public TableColumn<Show, Long> movie;
	@FXML
	public TableColumn<Show, String> date;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");



	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		cinema.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCinema()));
		movie.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getMovie()));
		date.setCellValueFactory(param -> new SimpleObjectProperty<>(dateFormat.format(param.getValue().getDate().getTime())));
	}

	public void setShowDaoJdbc(ShowDaoJdbc showDaoJdbc) {
		this.showDaoJdbc = showDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(showDaoJdbc.findAll()));
	}

}
