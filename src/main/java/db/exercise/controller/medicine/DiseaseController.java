package db.exercise.controller.medicine;

import db.exercise.dao.jdbc.medicine.DiseaseDaoJdbc;
import db.exercise.entities.medicine.Disease;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DiseaseController {

	private DiseaseDaoJdbc diseaseDaoJdbc;

	@FXML
	private TableView<Disease> tableView;

	@FXML
	public TableColumn<Disease, Long> idColumn;
	@FXML
	public TableColumn<Disease, String> titleColumn;

	@FXML
	private void initialize() {
		idColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		titleColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
	}

	public void setDiseaseDaoJdbc(DiseaseDaoJdbc diseaseDaoJdbc) {
		this.diseaseDaoJdbc = diseaseDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(diseaseDaoJdbc.findAll()));
	}
}
