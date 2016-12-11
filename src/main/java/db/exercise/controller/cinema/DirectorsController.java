package db.exercise.controller.cinema;

import db.exercise.dao.jdbc.cinema.DirectorDaoJdbc;
import db.exercise.entities.cinema.Director;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DirectorsController {

	private DirectorDaoJdbc directorDaoJdbc;

	@FXML
	private TableView<Director> tableView;
	@FXML
	public TableColumn<Director, Long> id;
	@FXML
	public TableColumn<Director, String> lastName;



	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		lastName.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getLastName()));
	}

	public void setMovieDaoJdbc(DirectorDaoJdbc directorDaoJdbc) {
		this.directorDaoJdbc = directorDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(directorDaoJdbc.findAll()));
	}


}
