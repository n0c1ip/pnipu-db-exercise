package db.exercise.controller.cinema;

import db.exercise.dao.jdbc.cinema.ThemeDaoJdbc;
import db.exercise.entities.cinema.Theme;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ThemesController {

	private ThemeDaoJdbc themesDaoJdbc;

	@FXML
	private TableView<Theme> tableView;
	@FXML
	public TableColumn<Theme, Long> id;
	@FXML
	public TableColumn<Theme, String> title;

	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		title.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getName()));
	}

	public void setThemeDaoJdbc(ThemeDaoJdbc themesDaoJdbc) {
		this.themesDaoJdbc = themesDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(themesDaoJdbc.findAll()));
	}

}
