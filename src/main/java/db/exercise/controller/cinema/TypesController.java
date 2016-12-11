package db.exercise.controller.cinema;

import db.exercise.dao.jdbc.cinema.TypeDaoJdbc;
import db.exercise.entities.cinema.Type;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TypesController {

	private TypeDaoJdbc typeDaoJdbc;

	@FXML
	private TableView<Type> tableView;
	@FXML
	public TableColumn<Type, Long> id;
	@FXML
	public TableColumn<Type, String> title;


	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		title.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getName()));
	}

	public void setTypeDaoJdbc(TypeDaoJdbc typeDaoJdbc) {
		this.typeDaoJdbc = typeDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(typeDaoJdbc.findAll()));
	}
}
