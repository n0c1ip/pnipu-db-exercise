package db.exercise.controller.cinema;

import db.exercise.dao.jdbc.cinema.CountryDaoJdbc;
import db.exercise.entities.cinema.Country;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CountriesController {

	private CountryDaoJdbc countryDaoJdbc;

	@FXML
	private TableView<Country> tableView;
	@FXML
	public TableColumn<Country, Long> id;
	@FXML
	public TableColumn<Country, String> title;


	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		title.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getName()));
	}

	public void setCountryDaoJdbc(CountryDaoJdbc countryDaoJdbc) {
		this.countryDaoJdbc = countryDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(countryDaoJdbc.findAll()));
	}

}
