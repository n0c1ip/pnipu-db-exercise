package db.exercise.controller.medicine;

import db.exercise.dao.jdbc.medicine.CardDaoJdbc;
import db.exercise.entities.medicine.Card;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Date;

public class CardController {

	private CardDaoJdbc cardDaoJdbc;

	@FXML
	private TableView<Card> tableView;
	@FXML
	public TableColumn<Card, String> patientNameColumn;
	@FXML
	public TableColumn<Card, String> doctorNameColumn;
	@FXML
	public TableColumn<Card, String> diseaseTitleColumn;
	@FXML
	public TableColumn<Card, Date> visitDateColumn;

	@FXML
	private void initialize() {
		patientNameColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPatientName()));
		doctorNameColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDoctorName()));
		diseaseTitleColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDiseaseTitle()));
		visitDateColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getVisitDate()));
	}

	public void setCardDaoJdbc(CardDaoJdbc cardDaoJdbc) {
		this.cardDaoJdbc = cardDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(cardDaoJdbc.findAll()));
	}
}
